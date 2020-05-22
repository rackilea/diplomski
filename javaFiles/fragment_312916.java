do {
    System.out.print("Enter your ID#: ");
    if (!input.hasNextInt()) {
        System.out.printf("%s is not an int.%n", input.nextLine());
        continue;
    }
    custid = input.nextInt();
    System.out.print("Enter your Account Number#: ");
    custacctnum = input.nextInt();
    if (!input.hasNextInt()) {
        System.out.printf("%s is not an int.%n", input.nextLine());
        continue;
    }