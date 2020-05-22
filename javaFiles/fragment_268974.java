private static void searchperson() {
    List<Person> personList = new ArrayList<>();
    for (int i = 1; i < 6; i++) {
        Person p = new Person(String.valueOf(i), String.valueOf(i), i);
        personList.add(p);
    }
    Collections.sort(personList, Comparator.comparingInt(Person::getAge));
    Person p = new Person("2", "2", 2);
    int indx = Collections.binarySearch(personList, p, Comparator.comparingInt(Person::getAge));
    System.out.println("index is:" + indx);
}