Person user = new Person();
user.setName("saltandwater");

List<Person> persons = new ArrayList<>();
persons.add(user);

List<List<Person>> personGroups = new ArrayList<>();
personGroups.add(new ArrayList<>(persons));