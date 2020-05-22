Scanner sc = new Scanner(System.in);
    System.out.println("Please enter letters:");
    while (!sc.hasNext("[A-Za-z]+")) {
        System.out.println("Nope, that's not it!");
        sc.next();
    }
    String word = sc.next();
    System.out.println("Thank you! Got " + word);