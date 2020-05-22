// 0. Specify the analyzer for tokenizing text.
     //    The same analyzer should be used for indexing and searching
     StandardAnalyzer analyzer = new StandardAnalyzer();

     final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

     // 1. create the index
     Directory index = new RAMDirectory();
     IndexWriterConfig config = new IndexWriterConfig(analyzer);
     IndexWriter w = new IndexWriter(index, config);
     long starttimeOfLoad = Calendar.getInstance().getTimeInMillis();
     System.out.println("Data Loading started");

     addEmployee(w, new EmployeeDto("John", "Smith", new Long(101), 10000, DATE_FORMAT.parse("2010-05-05"), DATE_FORMAT.parse("2018-05-05")));
     addEmployee(w, new EmployeeDto("Bill", "Thomas", new Long(102), 12000, DATE_FORMAT.parse("2011-06-06"), DATE_FORMAT.parse("2015-10-10")));
     addEmployee(w, new EmployeeDto("Franklin", "Robinson", new Long(102), 12000, DATE_FORMAT.parse("2011-04-04"), DATE_FORMAT.parse("2015-07-07")));
     addEmployee(w, new EmployeeDto("Thomas", "Boone", new Long(102), 12000, DATE_FORMAT.parse("2011-02-02"), DATE_FORMAT.parse("2015-03-10")));
     addEmployee(w, new EmployeeDto("John", "Smith", new Long(103), 13000, DATE_FORMAT.parse("2019-05-05"), DATE_FORMAT.parse("2099-12-31")));
     addEmployee(w, new EmployeeDto("Bill", "Thomas", new Long(102), 14000, DATE_FORMAT.parse("2011-06-06"), DATE_FORMAT.parse("2099-12-31")));

     w.close();
     System.out.println("Data Loaded. Completed in " + (Calendar.getInstance().getTimeInMillis() - starttimeOfLoad));

     // 2. query
     BooleanQuery finalQuery = null;
     try {
        // final query
        Builder builder = new BooleanQuery.Builder();

        // thom* query
        Query fullName = new QueryParser("fullName", analyzer).parse("thom" + "*");
        builder.add(fullName, Occur.MUST); // MUST implies that the keyword must occur.

        // greaterStartDate query
        long searchDate = DATE_FORMAT.parse("2014-05-05").getTime();
        Query greaterStartDate = LongPoint.newRangeQuery("startDatePoint", Long.MIN_VALUE, searchDate);
        builder.add(greaterStartDate, Occur.MUST); // Using all "MUST" occurs is equivalent to "AND" operator

        // lessTerminationDate query
        Query lessTerminationDate = LongPoint.newRangeQuery("terminationDatePoint", searchDate, Long.MAX_VALUE);
        builder.add(lessTerminationDate, Occur.MUST);
        finalQuery = builder.build();

     } catch (org.apache.lucene.queryparser.classic.ParseException e) {
         e.printStackTrace();
     }

     // 3. search
     long starttime = Calendar.getInstance().getTimeInMillis();
     int hitsPerPage = 100;
     IndexReader reader = DirectoryReader.open(index);
     IndexSearcher searcher = new IndexSearcher(reader);
     TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage);
     searcher.search(finalQuery, collector);
     ScoreDoc[] hits = collector.topDocs().scoreDocs;

     // 4. display results
     System.out.println("Found " + hits.length + " hits.");
     List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
     for (int i = 0; i < hits.length; ++i) {
         int docId = hits[i].doc;
         Document d = searcher.doc(docId);
         employeeDtoList.add(new EmployeeDto(d.get("firstName"), d.get("lastName"), Long.valueOf(d.get("employeeId")),
                 Integer.valueOf(d.get("salary"))));
     }

     System.out.println(employeeDtoList.size());
     System.out.println(employeeDtoList);
     System.out.println("Time taken:" + (Calendar.getInstance().getTimeInMillis() - starttime) + " ms");

 }

 private static void addEmployee(IndexWriter w, EmployeeDto employeeDto) throws IOException {
     Document doc = new Document();

     doc.add(new TextField("fullName", employeeDto.getFirstName() + " " + employeeDto.getLastName(), Store.YES));
     doc.add(new TextField("firstName", employeeDto.getFirstName(), Store.YES));
     doc.add(new TextField("lastName", employeeDto.getLastName(), Store.YES));
     doc.add(new StoredField("employeeId", employeeDto.getEmployeeId()));
     doc.add(new StoredField("salary", employeeDto.getSalary()));
     doc.add(new StoredField("startDate", employeeDto.getStartDate().getTime()));
     doc.add(new LongPoint("startDatePoint", employeeDto.getStartDate().getTime()));
     doc.add(new StoredField("terminationDate", employeeDto.getTerminationDate().getTime()));
     doc.add(new LongPoint("terminationDatePoint", employeeDto.getTerminationDate().getTime()));
     w.addDocument(doc);
 }