int attemptsNum = 0;
    final int maxAttempts = 3;
    do {
        System.out.print("Guess a number between 1 and 10: ");
        user = input.nextInt();

        if (user > comp)
            System.out.println("My number is less than " + user + ".");
        else if (user < comp)
            System.out.println("My number is greater than " + user + ".");
        else
            System.out.println("Correct! " + comp + " was my number! ");
    } while (user != comp && ++attemptsNum <maxAttempts );

    if (attemptsNum == maxAttempts)
        System.out.println("You loose. The number was :" + comp);