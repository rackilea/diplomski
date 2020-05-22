String[] test = new String[]{"one", "two", "one", "three"};

    System.out.println("Before:");
    System.out.println(Arrays.toString(test));

    test = removeFromArray(test, "one"); //Call our method

    System.out.println("\nAfter:");
    System.out.println(Arrays.toString(test));