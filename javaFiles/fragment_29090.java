Comparator<MyObject> comp = new Comparator<MyObject>{
  public int compare(MyObject o1, MyObject o2) {
    // NOTE this compare is not very good as it obeys the contract but
    // is not consistent with equals. compare() == 0 -> equals() != true here
    // Better to use some more fields
    return o1.getId().hashCode() < o2.getId().hashCode();
  }
  public boolean equals(Object other) {
    return 01.getId().equals(o2.getId());
  }
}

Set<MyObject> myObjects = new TreeSet(comp);