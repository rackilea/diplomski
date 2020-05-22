Scanner input = new Scanner(System.in);
    int array_length = 5;

    String value;
    while (!"R".equals(value = input.next()) &&
            !"r".equals(value) &&
            !(value.matches("[0-9]+") && Integer.parseInt(value) >= 0 && Integer.parseInt(value) < array_length )) {
        System.out.println("Invalid option entered. Please try again.");
        System.out.println();
        System.out.print("Select option > ");
    }

    System.out.println("Thanks!");