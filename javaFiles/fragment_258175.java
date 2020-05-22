Scanner scanner = new Scanner(System.in);
    int choice = 0;
    do {
        System.out.print("Please Pick A Number Between 1-20!");
        choice = scanner.nextInt();
    } while(choice > 20 || choice < 1);