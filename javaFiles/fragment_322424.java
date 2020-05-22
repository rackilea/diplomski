public List<Person> getDiseaseRouteTo(Person c) {
    List<Person> path = new LinkedList<Person>();
    return getDiseaseRouteTo(c, path);
}

private List<Person> getDiseaseRouteTo(Person c, List<Person> path) {
    // ...
}