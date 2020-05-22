// add all strings from each new line to an ArrayList 
    while (scanner.hasNextLine()) {
        varArray.add(scanner.nextLine());
    }
    // close your streams
    scanner.close();

    // iterate the ArrayList and print all values
    for (String var : varArray) {
        System.out.println(var);
    }

    // grab value by its index in the ArrayList
    System.out.println("Get variable from index 2: " + varArray.get(2));