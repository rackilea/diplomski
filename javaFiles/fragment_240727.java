TreeSet<Person> personSetByAddress = new TreeSet<>();
    Person personA = new Person();
    personA.setCountry("A");
    personSetByAddress.add(personA);
    Person personB = new Person();
    personB.setCountry("A");
    personB.setState("B");
    personSetByAddress.add(personB);
    Person personC = new Person();
    personC.setCountry("A");
    personC.setState("B");
    personC.setCity("C");
    personSetByAddress.add(personC);

    Address addressAB = new Address();
    addressAB.setCountry("A");
    addressAB.setState("B");

    System.out.println(personSetByAddress.floor(new AddressPersonAdapter(addressAB)));

    Yields:
    Person{hashCode=10010000, country='A', state='B', city='null'}