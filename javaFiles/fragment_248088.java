List<Person> list = new LinkedList<>();
list.add(new Person("Pete", Company.APPLE));
list.add(new Person("Joe", Company.APPLE));
list.add(new Person("Jack", Company.APPLE));
list.add(new Person("Robert", Company.MICROSOFT));
list.add(new Person("Cate", Company.MICROSOFT));
list.add(new Person("Abi", Company.MICROSOFT));

Map<Company, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getCompany));
map.values().forEach(persons -> {
    int maxLen = persons.stream().mapToInt(p -> p.getName().length()).max().getAsInt();
    persons.removeIf(p -> p.getName().length() != maxLen);
});

System.out.println(map);