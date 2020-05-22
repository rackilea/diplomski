Morphia morphia = new Morphia();
        Datastore datastore = morphia.createDatastore(new MongoClient(), "test");

        Person johnDoe = new Person("John", "Doe");

        //saves John Doe on DB
        datastore.save(johnDoe);

        //retrieves all people whose first name is John
        List<Person> people = datastore.createQuery(Person.class).filter("firstName", "John").asList();

        System.out.println(people.size()); //prints 1
        Person person = people.get(0);

        System.out.println(person); //prints John Doe