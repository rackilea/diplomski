// 2. query
 BooleanQuery finalQuery = null;
 try {
    // final query
    finalQuery = new BooleanQuery();

    // thom* query
    Query fullName = new QueryParser(Version.LUCENE_40, "fullName", analyzer).parse("thom" + "*");
    finalQuery.add(fullName, Occur.MUST); // MUST implies that the keyword must occur.

    // greaterStartDate query
    long searchDate = DATE_FORMAT.parse("2014-05-05").getTime();
    Query greaterStartDate = NumericRangeQuery.newLongRange("startDate", null, searchDate, true, true);
    finalQuery.add(greaterStartDate, Occur.MUST); // Using all "MUST" occurs is equivalent to "AND" operator

    // lessTerminationDate query
    Query lessTerminationDate = NumericRangeQuery.newLongRange("terminationDate", searchDate, null, false, false);
    finalQuery.add(lessTerminationDate, Occur.MUST); 

 } catch (org.apache.lucene.queryparser.classic.ParseException e) {
     e.printStackTrace();
 }