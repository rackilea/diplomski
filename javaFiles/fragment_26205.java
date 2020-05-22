MyObject first = new MyObject(1);
    MyObject second = new MyObject(2);
    List<MyObject> list = Arrays.asList(first, second);

    System.out.println(list);
    list.stream().forEach(x -> x.setValue(x.getValue() + 1));
    System.out.println(list);