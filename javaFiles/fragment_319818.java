Scanner choose = new Scanner(System.in);
    String choice= null;
    int j = 0;
    while (!"end".equals(choice)) {
        System.out.println("\nType 1, 2, or 3 and press enter to see the monthly payment information for the respective loan. To end the program type \"end\".");
        choice = choose.nextLine();
        if ("1".equals(choice)) {
           //calculation code
               if (j < 6) {
                    System.out.println("Press enter to get the mortgage information for year " + (j + 2));
                    choice = choose.nextLine();
                } else {
                    System.out.println("Congratulations, your mortgage has been paid off.");
                }
            choice = null;
        }
        if ("2".equals(choice)) {
                if (j < 14) {
                    System.out.println("Press enter to get the mortgage information for year " + (j + 2));
                    choice = choose.nextLine();
                } else {
                    System.out.println("Congratulations, your mortgage has been paid off.");
                }
            choice = null;
        }
        if ("3".equals(choice)) {
                if (j < 29) {
                    System.out.println("Press enter to get the mortgage information for year " + (j + 2));
                    choice = choose.nextLine();
                } else {
                    System.out.println("Congratulations, your mortgage has been paid off.");
                }
            choice = null;
        }
    }
    choose.close();