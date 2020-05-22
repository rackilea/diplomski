List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(21);
    numbers.add(35);
    for (Integer name : numbers) {
        System.out.println(name); // 1, 21, 35
    }
    System.out.println("-------");
    numbers.remove((Integer) 21);
    for (Integer name : numbers) {
        System.out.println(name); // 1, 35
    }
    System.out.println("-------");
    numbers.remove((int) 0);
    for (Integer name : numbers) {
        System.out.println(name); // 35
    }