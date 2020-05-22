TreeSet<Person> personSetByAddress = new StrictCountryTreeSet();
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
    null