if (balance - amount - 5 < 0) {
        System.out.println("Insufficent funds");
        System.out.println("Would you like to apply for an ovedraft?");
        System.out.println("1:Yes");
        System.out.println("2:No, return me back to menus");
        Choice = Option.nextLine();
        if (Choice.equalsIgnoreCase("1")) {
            if (balance - amount - 5 <= -150) {
                System.out.println("You have exceeded your Overdraft Limit, you will now be returned back to the menus");
            } else { //if not exceeding bank balance
                balance -= amount + 5;
                System.out.println("You have withdrawen £" + amount);
                System.err.println("You now have a balance of £" + balance);
            }