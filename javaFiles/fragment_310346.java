Map<String, Comparator<Person>> map = new HashMap<>();
map.put("name_ASC", Comparator.comparing(Person::getName));
map.put("name_DESC", Comparator.comparing(Person::getName).reversed());

map.put("age_ASC", Comparator.comparingInt(Person::getAge));
map.put("age_DESC", Comparator.comparingInt(Person::getAge).reversed());