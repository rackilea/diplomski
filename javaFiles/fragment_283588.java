boolean done = false; 
        while(!done) {
            System.out.println("Welcome to Running Bank"
                        + "\nWhat would you like to do?"
                        + "\n1-Create Account"
                        + "\n2-Log-In"
                        + "\n3-Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
            case 1:
                System.out.println("Input your username(No more than 15 characters: ");
                Username = scanner.nextLine();
                System.out.println("Input your password(Must be at least 8 characters and not over 24): ");
                Password = scanner.nextLine();
        }
    }
}