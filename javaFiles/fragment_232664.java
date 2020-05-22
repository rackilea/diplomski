Scanner in = new Scanner(System.in);

    while (true) {
        System.out.print("CODE: (X to terminate)");
        String code = in.nextLine();
        if (code.equalsIgnoreCase("x")) {
            break;
        }

        System.out.print("QUANTITY: ");
        int quantity = in.nextInt();
        in.nextLine();
    }