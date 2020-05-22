Vector vector = new Vector();
    vector.add("value1");
    vector.add("value2");
    vector.add("value3");
    vector.add("value4");
    System.out.println("Size : "+vector.size());
    // to remove single value
    vector.remove("value1");
    System.out.println("Size : "+vector.size());
    Vector itemsToRemove = new Vector();
    itemsToRemove.add("value3");
    itemsToRemove.add("value4");
    //remove multiple values
    vector.removeAll(itemsToRemove);
    System.out.println("Size : "+vector.size());

    //to remove all elements
    vector.removeAllElements();
    // or
    vector.clear();