class PersonsAgeIndex {

    private NavigableMap<Integer, List<Person>> ageToPersons = 
                                    new TreeMap<Integer, List<Person>>();

    public void addPerson( Person p ) {
        List<Person> personsWithSameAge = this.ageToPersons.get( p.age );

        if ( personsWithSameAge == null ) {
            personsWithSameAge = new LinkedList<Person>();
            this.ageToPersons.put( p.age, personsWithSameAge );
        }

        personsWithSameAge.add( p );
    }

    public List<Person> personsWithAgeLessThan( int age ) {
        List<Person> persons = new LinkedList<Person>();

        // persons with less age
        for (List<Person> tmp : this.ageToPersons.headMap( age ).values()) {
            persons.addAll( tmp );
        }

        return persons;
    }

    public List<Person> personsWithAgeInInterval( int minAge, int maxAge ) {
        List<Person> persons = new LinkedList<Person>();

        // persons with age, which: (minAge <= age <= maxAge)
        for (List<Person> tmp : this.ageToPersons.subMap( minAge, true, maxAge, true ).values()) {
            persons.addAll( tmp );
        }

        return persons;
    }

}

class Person {
    public final int age;

    public Person(int age) {
        this.age = age;
    }
}