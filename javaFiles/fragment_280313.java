for (int i : iter(3)) {
        System.out.println(i);  // 0, 1, 2
    }

    for (int i : iter(-5)) {
        System.out.println(i);  // 0, -1, -2, -3, -4
    }

    for (int i : iter(1, 7)) {
        System.out.println(i);  // 1, 2, 3, 4, 5, 6
    }