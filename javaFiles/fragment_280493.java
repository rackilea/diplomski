String[] HEADERS = { "SK","VR","ST","PR"};

        Reader in = new FileReader("mycsvfile.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
          .withHeader(HEADERS)
          .withFirstRecordAsHeader()
          .parse(in);

        // Group the records by  SK
     Map<String, List<CSVRecord>> recordListBySK =   StreamSupport
            .stream(records.spliterator(), false).
            collect(Collectors.groupingBy(record -> record.get("SK")));