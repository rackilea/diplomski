Denied d2 = new Denied();
    d2.id = new ObjectId("52b4709f423d856472c34fa1");

    List list = datastore
            .createQuery(Linf.class)
            .field("denied")
            .equal(d2).asList();