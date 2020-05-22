Map<String, MyValue> map = new HashMap<>();
    System.out.println("empty map = " + GraphLayout.parseInstance(map).totalSize());

    MyValue one = new MyValue(1, "one");
    System.out.println("one = " + GraphLayout.parseInstance(one).totalSize());

    map.put("one", one);
    System.out.println("map after one = " + GraphLayout.parseInstance(map).totalSize());

    MyValue two = new MyValue(1, "two");
    map.put("two", two);
    System.out.println("map after two = " + 
    GraphLayout.parseInstance(map).totalSize());