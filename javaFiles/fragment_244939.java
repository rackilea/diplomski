if (lineFromFile.contains(s)) {
    String temp = scanner.nextLine();
    System.out.println(temp);

    flag_found = 1;

    System.out
            .println(" Would you like to update this information ? ");
    String yellow = forget.nextLine();
    if (yellow.equals("yes")) {
        // String black = scanner.nextLine();
        removedata(temp);
    } else if (yellow.equals("no")) {

        System.out.println("Have a good day");
        // break;
    }

    // Add return statment to end the search
    return;
}