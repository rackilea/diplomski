String test1 = "foo bar abc";
    String test2 = "bar abc foo";

    HashSet<String> set1 = new HashSet<>(Arrays.asList(test1.split(" ")));
    HashSet<String> set2 = new HashSet<>(Arrays.asList(test2.split(" ")));

    System.out.println(set1.equals(set2));