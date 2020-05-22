Map<String, Foo> map = new HashMap<String, Foo>();

    Foo f1 = new Foo("name1");
    Foo f2 = new Foo("name2");
    Foo f3 = new Foo("name3");

    map.put("name1", f1);
    map.put("name2", f2);
    map.put("name3", f3);

    // will return true and this if statement will be executed
    if (map.containsKey("name1"))
    {
        // will be executed
    }

    // will return false because you don't have and this if statement will not be executed
    if (map.containsKey("some new name"))
    {
        // will not be executed
    }