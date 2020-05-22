try (Scanner sc = new Scanner(System.in)) {
    String msg = "Please, enter a positive Integer:";
    int n = 0;

    do {
        System.out.println(msg);
        // make the user keep entering the input until it's an Integer
        while (!sc.hasNextInt()) {
            System.out.println(msg);
            sc.next();
        }
        n = sc.nextInt();
    }
    while (n <= 0); // run until the input is a positive Integer

    return n;
}