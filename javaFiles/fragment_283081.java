List<Foo> list = new ArrayList<Foo>();

    boolean hasMyItem = false;
    String newName = "hello world";

    for (Foo foo : list)        // iterate over each item in the list
    {
        if (foo.name.equals(newName))
        {
            hasMyItem = true;
            break;            // get out of for loop
        }
    }

    if (!hasMyItem)
    {
        list.add(new Foo(newName));
    }
    else
    {
        // the player is already in the list ...
    }