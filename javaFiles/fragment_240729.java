TreeSet<Person> personSetByAddress = new TreeSet<>();
    Person personA = new Person();
    personA.setCountry("D");
    personSetByAddress.add(personA);
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
    Person{hashCode=10000000, country='D', state='null', city='null'}