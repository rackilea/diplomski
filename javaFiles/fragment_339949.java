List<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    list.add("c");
    System.out.println(list); // [a,b,c]

    list.remove("a");
    System.out.println(list); // [b,c]

    List<String> unmodifiable = Collections.unmodifiableList(list);
    unmodifiable.remove("b"); // UnsupportedOperationException