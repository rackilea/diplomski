catch(InputMismatchException e)
    {
        System.out.print("The phrase entered is not a valid number." + "\n" + prefixString + ": ");
        validResponse = false;
        scanner.next();
    }