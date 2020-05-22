System.out.println("Enter a numeric date formatted as month/day or \"Exit\" to quit.");

    String inputStr = sc.nextLine();
    if (inputStr.equalsIgnoreCase("Exit")) {
        System.out.println("Goodbye");
        System.exit(0);
    }
    // more validation could be done here
    String[] input = inputStr.split("/");