Scanner scanner = new Scanner(System.in);
    String option = null;

    ShowMenu();
    option = scanner.nextLine();

    while (!"5".equals(option)) {
        switch (option) {
            case "1": ViewAllProducts(); break;
            case "2": ViewProductDetails(scanner); break;
            case "3": DeleteProduct(scanner); break;
            case "4": AddProduct(scanner); break;
            case "5": break;
            default: System.out.println("Invalid option. Please try again..."); break;
        }
        ShowMenu();
        scanner = new Scanner(System.in);  // Add this here

        option = scanner.nextLine();    // Use brand new scanner without any problem..
    }