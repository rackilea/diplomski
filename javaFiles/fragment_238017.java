List<Person> ps = new ArrayList<>(Arrays.asList(
    new Person("A", "D"), new Person("B",  "C")));
  ...

  Comparator<Person> byNameComparator = 
    newMethodComparator(Person.class, "getName");
  Collections.sort(ps,  byNameComparator);