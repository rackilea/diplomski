Person per = Iterables.tryFind(persons, new Predicate<Person>() {
        @Override
        public boolean apply(Person person) {
            return person.getAge()> 50;
        }
    }).or(defaultPerson);