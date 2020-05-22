if (records.size()<10){
  records.add(...); // add your newly created record

} else if (records.get(9).getScore()<score) {
  // elements in a list are 0-based, 9 means 10th element
  // score is a score of a new element, which user wants to enter

  records.remove(9);
  records.add(...); // add your newly created record
  Collections.sort(records, new GameRecordsComparator());
}