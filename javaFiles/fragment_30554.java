Scanner sc = new Scanner(System.in);
    double dbl = 0.0;
    boolean isValid = false;
    while (isValid == false) {
        System.out.println("Input Number: ");
        // If input is number execute this,
        if (sc.hasNextDouble()) {
            dbl = sc.nextDouble();
            isValid = true;
            System.out.println("OK");
        }
        // If input is not a number execute this block, 
        else {
            System.out.println("Error! Invalid number. Try again.");
        }
        sc.nextLine(); // discard any other data
    }
    sc.close();