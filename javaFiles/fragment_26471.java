while (true) {
    letter = GettingUserInput(input);
    System.out.println("value of letter: " + letter);

    if (letter=='A' || letter =='a') {
        valueOfA = InputWasA();
        System.out.println(valueOfA);
    }

    // etc