int choice = -1;
        while (choice < 0 || choice > 4) {
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter Decimal Number");
                    break;
                case 2:
                    System.out.println("\nEnter Decimal Number");
                    break;
                case 3:
                    System.out.println("\nEnter Binary");
                    break;
                case 4:
                    System.out.println("\nEnter Hexadecimal");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please choose a number between 1 and 4.");
                    break;

            }
        }