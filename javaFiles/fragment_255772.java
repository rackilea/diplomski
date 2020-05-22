public Map<LocalDate, List<Foo>> groupByDate(List<Foo> foos) {
  Map<LocalDate, List<Foo>> groupedFoo = new HashMap()<..>
  for(Foo foo : foos) {
    Date javaDate = foo.getDate();
    LocalDate jodaDate = new LocalDate(javaDate);
    List<Foo> dateGroupedFoos = groupedFoo.get(jodaDate);
    if (null == dateGroupedFoos) {
      dateGroupedFoos = new ArrayList()<..>;
      groupedFoo.put(jodaDate, dateGroupedFoos);
    }
    dateGroupedFoos.add(foo);
  }
}