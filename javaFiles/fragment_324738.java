switch (myScanner.nextInt()) {
            case 1:
                System.out.println("You have added a Toaster to your order.");
                userTotal += menuPrices[0];
                break;
            case 2:
                System.out.println("You have added a Coffee to your order.");
                userTotal += menuPrices[0];
                break;
            case 3: (continue with same..)
            default:
                System.out.println("Invalid item number please try again");
        }