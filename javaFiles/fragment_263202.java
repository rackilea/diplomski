Container before = new Container("test");

    Containee one = new Containee("one");
    Containee two = new Containee("two");
    Containee three = new Containee("three");

    before.getContents().add(one);
    before.getContents().add(two);
    before.getContents().add(three);

    pm = pmf.getPersistenceManager();

    try
    {
        pm.makePersistent(before);
    }
    finally
    {
        pm.close();
    }

    pm = pmf.getPersistenceManager();

    try
    {
        Container after = pm.getObjectById(Container.class, "test");

        // prints 3
        System.out.println("Pre-remove set cardinality "
                + after.getContents().size());

        // prints "true"
        System.out.println("Post-store containment: "
                + after.getContents().contains(one));

        //get a reference to the object in the persisted Set
        //that is value-equivalent to Containee #1
        Containee ref = null;
        for (Containee c : after.getContents())
        {
            if (c.equals(one)) ref = c;
        }

        if (ref != null)
        {
            after.getContents().remove(ref);
        }

        // prints 2
        System.out.println("Post-remove set cardinality: "
                + after.getContents().size());

    }
    finally
    {
        pm.close();
    }

    pm = pmf.getPersistenceManager();

    try
    {
        Container after = pm.getObjectById(Container.class, "test");

        // prints 2 (as expected)
        System.out.println("Final set cardinality "
                + after.getContents().size());
    }
    finally
    {
        pm.close();
    }