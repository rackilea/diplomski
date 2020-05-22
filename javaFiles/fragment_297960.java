Scanner scanner = new Scanner(System.in);

    System.out.print("path:");
    while (!scanner.hasNext("[a-zA-Z0-9/]+")) {
        System.out.println("Invalid path. Try again:");
        scanner.next();
    }
    String path = scanner.next();
    System.out.println("path:"+path);