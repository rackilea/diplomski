List<Integer> x = new ArrayList<Integer>();
    x.add(1);
    x.add(2);
    x.add(3);
    x.add(4);
    x.add(5);

    List<Integer> y = new ArrayList<Integer>();
    y.add(1);
    y.add(2);
    y.add(3);

    final List<Integer> z = new ArrayList<>(x.subList(0, 4));

    System.out.println("sublist " + z.toString());

    z.removeAll(y);

    System.out.println("Main list after removing sublist " + x.toString());