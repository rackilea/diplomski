// Data of Array of Object for test the Code
    Object[] a = new Object[1];
    a[0] = "Hello";
    Object[] b = new Object[1];
    b[0] = "Friend";
    Object[] c = new Object[1];
    c[0] = "This is";
    Object[] d = new Object[1];
    d[0] = "Just Test";

    // The Array List of objects and the data entry
    ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
    arrayList.add(a);
    arrayList.add(b);
    arrayList.add(c);
    arrayList.add(d);

    // New List of strings
    List<String> strings = new ArrayList<>(arrayList .size());


    // The Process of adding the data from array list of objects to the strings
    for(int i = 0; i < arrayList.size(); i++){
        strings.add((String) arrayList.get(i)[0]);
    }

    // Just for print the data to console
    for(int i = 0 ; i < strings.size(); i++){
        System.out.println(strings.get(i));
    }

    System.out.println("askldnlkasdn "+strings.get(0));