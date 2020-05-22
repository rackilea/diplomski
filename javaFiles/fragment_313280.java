System.out.print("Please enter a key: ");

    String test = console.nextLine();
    while (!test.matches("^[a-z]+$")) {
        System.out.println("Invalid key");
        test = console.nextLine();
    }
    System.out.println(test);