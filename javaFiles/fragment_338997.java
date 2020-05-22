System.out.print("Enter a five digit integer number: ");

    int fiveInt, digit1, digit2, digit3, digit4, digit5; // Declaring
                                                            // variables

    Scanner keyboard = new Scanner(System.in);

    fiveInt = keyboard.nextInt(); // User input will be required

    System.out.println(" "); // Prints empty line

    // The following will be explained assuming number entered was 12345.
    // The (int) will change whatever result of the division taking place to
    // an integer.

    digit1 = (int) (fiveInt / 10000); // 12345 divided by 10000 = 1.2345
                                        // converted to 1 due to (int).
    digit2 = ((int) (fiveInt / 1000)) - (digit1 * 10); // 12345 divided by
                                                        // 1000 = 12.345 -
                                                        // (1 * 10) = 2.345
                                                        // converted 2 due
                                                        // to (int).
    digit3 = ((int) (fiveInt / 100)) - (digit1 * 100) - (digit2 * 10); // 12345
                                                                        // divided
                                                                        // by
                                                                        // 100
                                                                        // =
                                                                        // 123.45
                                                                        // -
                                                                        // (1*100)
                                                                        // -
                                                                        // (2*10)
                                                                        // =
                                                                        // 3.45
                                                                        // converted
                                                                        // to
                                                                        // 3
                                                                        // due
                                                                        // to
                                                                        // (int).
    digit4 = ((int) (fiveInt / 10)) - (digit1 * 1000) - (digit2 * 100)
            - (digit3 * 10); // 12345 divided by 10 = 1234.5 - (1*1000) -
                                // (2*100) - (3*10) = 4.5 converted to 4 due
                                // to (int).
    digit5 = fiveInt - (digit1 * 10000) - (digit2 * 1000) - (digit3 * 100)
            - (digit4 * 10); // 12345 - (1*10000) - (2*1000) - (3*100) -
                                // (4*10) = 5

    System.out
            .println("The digits in " + fiveInt + " are: " + digit1 + ", "
                    + digit2 + ", " + digit3 + ", " + digit4 + ", "
                    + digit5);

    System.out.println(" "); // Prints empty line

    // Insert explanation for lines of code below here.

    if (digit1 < digit2) {
        int a = digit1;
        digit1 = digit2;
        digit2 = a;
    }

    if (digit2 < digit3) {
        int b = digit2;
        digit2 = digit3;
        digit3 = b;
    }

    if (digit3 < digit4) {
        int c = digit3;
        digit3 = digit4;
        digit4 = c;
    }

    if (digit4 < digit5) {
        int d = digit4;
        digit4 = digit5;
        digit5 = d;
    }

    // 2nd Filtering

    if (digit1 < digit2) {
        int a = digit1;
        digit1 = digit2;
        digit2 = a;
    }

    if (digit2 < digit3) {
        int b = digit2;
        digit2 = digit3;
        digit3 = b;
    }

    if (digit3 < digit4) {
        int c = digit3;
        digit3 = digit4;
        digit4 = c;
    }
    // 3rd Filtering

    if (digit1 < digit2) {
        int a = digit1;
        digit1 = digit2;
        digit2 = a;
    }

    if (digit2 < digit3) {
        int b = digit2;
        digit2 = digit3;
        digit3 = b;
    }

    // last filtering
    if (digit1 < digit2) {
        int a = digit1;
        digit1 = digit2;
        digit2 = a;
    }

    // Insert explanation for lines of code above here.

    System.out.print("The largest number with these digits is: " + digit1
            + digit2 + digit3 + digit4 + digit5); // Displays the digits in
                                                    // their sorted mann