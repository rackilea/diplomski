Map<String, Person> getOldestPersonPerSchool(Set<Person> persons) {
    return persons.stream()
            .collect(Collectors.toMap(
                    Person::getSchoolname,  // school name
                    Function.identity(), // person
                    (a, b) -> a.getAge() > b.getAge() ? a : b)); // ensure to store oldest (no tie breaker for same age)
}