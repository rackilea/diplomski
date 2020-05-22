public static Set<Person> getPersonLevel(Person person, int depth) {
    Set<Person> ppl= new HashSet<>();
    if (depth > 0) {
         person.getPeople().forEach(prs -> ppl.addAll(getPersonLevel(prs, depth - 1)));
    }
    return ppl;
}