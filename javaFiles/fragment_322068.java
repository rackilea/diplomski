Scanner sc = new Scanner(System.in);
    while (!sc.hasNextInt()) {
        System.out.println("int, please!");
        sc.nextLine(); // discard!
    }
    int i = sc.nextInt(); // guaranteed not to throw InputMismatchException