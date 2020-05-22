List<Map.Entry<Foo, Bar>> entryList = 
  new ArrayList<Map.Entry<Foo, Bar>>(map.entrySet());
Collections.sort(entryList, new Comparator<Map.Entry<Foo, Bar>>() {
  public int compare(Map.Entry<Foo, Bar> entry1, Map.Entry<Foo, Bar> entry2) {
    return entry1.getValue().compareTo(entry2.getValue());
  }
});