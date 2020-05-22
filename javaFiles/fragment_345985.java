Scanner sc = new Scanner(System.in);
    double x = 0;
    System.out.println("Enter price");

    while (true) {
        if (!sc.hasNextDouble()) {
            System.out.println("Sorry price cant be negative or be letter");
            break;
        }
        System.out.println("Enter price");
        x = sc.nextDouble();
    }