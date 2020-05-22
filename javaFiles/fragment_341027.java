//Step 1: collect all the columns that have values
Set<Character> columns = new LinkedHashSet<>();
for(Character row : charFrequentie.keySet()){
  //gets the mapped characters for the row and adds them in the order they are returned ignoring any duplicates 
  columns.addAll(charFrequentie.get(row).keySet());
}

//Step 2: print
for( Character col : columns ) {
  //print the columns as the first line
}

//here you iterate over the rows since you'll print line by line
for(Character row : charFrequentie.keySet()){
  //go over the columns in the same order for each row
  for( Character col : columns ) {
    //get the frequency for the column in that row, which might be null       
    Integer frequency = charFrequentie.get(row).get(col);

    //if there is no value for the column in the current row just print 0
    if( frequency == null ) {
      //print 0
    } else {
      //there is a frequency value so just print it         
    }
  }
}