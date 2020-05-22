Collections.sort(myList, new Comparator<Statements>() {
  public int compare(Statements o1, Statements o2) {
    if (o1.getEndDate() == null || o2.getEndDate() == null)
       return 0;
    return o1.getEndDate().compareTo(o2.getEndDate());
 }
});