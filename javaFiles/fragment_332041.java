public static void main(String[] args) {
    List<Person> persons = Arrays.asList(
        new Person("John", new ChildrenListHolder(Arrays.asList(new Children("Lisa"), new Children("Jimmy")))),
        new Person("Clara", new ChildrenListHolder(Arrays.asList(new Children("Lisa"), new Children("Paul")))),
        new Person("George", new ChildrenListHolder(Arrays.asList(new Children("Paul"))))
    );

    Map<String,List<Person>> map =
        persons.stream()
               .flatMap(p -> p.childrenListHolder.children.stream().map(c -> new AbstractMap.SimpleEntry<>(c, p)))
               .collect(Collectors.groupingBy(
                 e -> e.getKey().childrensName,
                 Collectors.mapping(Map.Entry::getValue, Collectors.toList())
               ));

    System.out.println(map);
}