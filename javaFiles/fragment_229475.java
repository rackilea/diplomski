public Set<Person> getPersonLevel(Person person, int depth) {
       Set<Person> aList = new HashSet<>();

       if (depth == 1)
           aList.addAll(person.getPeople());

       if (depth > 1){
           for (Person pp : person.getPeople()) {
                   aList.addAll(getPersonLevel(pp, depth -1));
           }
       }
       return aList;
    }