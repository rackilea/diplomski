boolean askAgain = true;
    while (askAgain) {
        iSBnNum = 1;
        while (iSBnNum <= isbn10) {
            System.out.println("Please ISBN number  " + iSBnNum);
            // to enter the User response
            userResponse = keyboard.nextInt();
            // Multiply the user response by multiplier variable
            userResponse = userResponse * multiplier;
            // add to accumulator
            iSBnNum = iSBnNum + 1;
            // put user into final answer
            isbnCount = isbnCount + userResponse;
            // increase multiplier
            multiplier = multiplier + 1;
        }

        System.out.println("Ask again (Y/N)?");
        String answer = keyboard.next();

        askAgain = answer.equalsIgnoreCase("Y");
    }