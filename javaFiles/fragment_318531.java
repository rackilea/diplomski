LinkedList<String> a = new LinkedList<String>();

    a.add("as");
    a.add("sa");
    a.add("bb");

    a.add("as");
    a.add("sa");

    a.add("bb");
    a.add("d");
    a.add("ya");

    List<String> b = Collections.unmodifiableList(a.subList(0, 3));
    List<String> c = Collections.unmodifiableList(a.subList(5, 8));


    b.set(0, "aa"); // not allowed
    c.add("zz"); // not allowed

    a.set(6, "zz"); // allowed and List c is also updated.