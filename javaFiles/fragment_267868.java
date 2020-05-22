Map<TravelRow> result = new HashMap<TravelRow>();
CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));
String [] nextLine;
while ((nextLine = reader.readNext()) != null) {
   // nextLine[] is an array of values from the line
   if( result.containsKey(nextLine[0]) ) {
       // compare the review
       if( reviewNeedsUpdate(result.get(nextLine[0]), nextLine[4]) ) {
           result.get(nextLine[0]).setReview(nextLine[4]); // update only the review, create a new object, if you like
       }
   }
   else {
       // create TravelRow with array using the constructor eating the line
       result.put(nextLine[0], new TravelRow(nextLine));
   }
}