List<String> list = Arrays.asList(
        "one", "two", "three", null, "two", null, "five"
    );
    System.out.println(list);
    // [one, two, three, null, two, null, five]

    Collections.replaceAll(list, "two", "one");
    System.out.println(list);
    // [one, one, three, null, one, null, five]

    Collections.replaceAll(list, "five", null);
    System.out.println(list);
    // [one, one, three, null, one, null, null]

    Collections.replaceAll(list, null, "none");
    System.out.println(list);
    // [one, one, three, none, one, none, none]