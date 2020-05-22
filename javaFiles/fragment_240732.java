TreeSet<Person> personSetByAddress = new StrictCountryTreeSet();
    Person personD = new Person();
    personD.setCountry("D");
    personSetByAddress.add(personD);

    Person personE = new Person();
    personE.setCountry("A");
    personE.setState("E");
    personSetByAddress.add(personE);

    Person personC = new Person();
    personC.setCountry("A");
    personC.setState("B");
    personC.setCity("C");
    personSetByAddress.add(personC);

    Address addressA = new Address();
    addressA.setCountry("A");

    Address addressAB = new Address();
    addressAB.setCountry("A");
    addressAB.setState("B");

    Address addressABC = new Address();
    addressABC.setCountry("A");
    addressABC.setState("B");
    addressABC.setCity("C");

    System.out.println(personSetByAddress.floor(new AddressPersonAdapter(addressAB)));

    Yields:
    null