new ArrayList<Person>().stream().collect(Collectors.toMap(
        new Function<Person, Person>() {                    // Function to create a key
            @Override
            public Person apply(Person person) {
                return person;                              // ... return self
            }},
        new Function<Person, Timer>() {                     // Function to create a value
            @Override
            public Timer apply(Person person) {
                return new Timer();                         // ... return a new Timer
            }}
    ));