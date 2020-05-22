List<People> people = Arrays.asList(
        new People("John", 25, "M"),
        new People("Jane", 25, "F"),
        new People("Pete", 25, "M"),
        new People("Albert", 25, "M"),
        new People("Victor", 25, "M")
);

List<String> names = Arrays.asList("John", "Pete", "Victor");

List<People> filtered = people.stream()
        .filter(p -> names.contains(p.getName())) // if the name of p is contained in the list of string names to filter
        .collect(Collectors.toList());