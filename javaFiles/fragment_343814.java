final PrintStream printStream = new PrintStream(outputStream);
    while(true) {

        System.out.print("Pass me a message: ");
        String input = sc.nextLine();

        printStream.print(input);
        printStream.flush();
    }