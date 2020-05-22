while (inFile.hasNextLine()) {
    String marketName = inFile.nextLine();

    while (inFile.hasNextLine()) {
        String line = inFile.nextLine();
        if (line.isEmpty()) {
            break;
        }

        // create a new Scanner just
        // for this line so it doesn't
        // mess up the calls to nextLine
        Scanner lineIn = new Scanner(line);

        Sting fruitName = lineIn.next();
        int price = lineIn.nextInt();
        int stock = lineIn.nextInt();
        ...
    }

    ...
}