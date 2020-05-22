RowFilter<Object,Object> startsWithAFilter = new RowFilter<Object,Object>() {
  public boolean include(Entry<? extends Object, ? extends Object> entry) {
    for (int i = entry.getValueCount() - 1; i >= 0; i--) {
      if (entry.getValue(i).equals(true)) {
       return true;
      }
    }
    return false;
 }
};