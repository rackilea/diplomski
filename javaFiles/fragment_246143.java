Scanner in = new Scanner(System.in);
    double length1;
    while (true) {
        System.out.print("Please enter the length in centimeters : ");
        String s = in.next();
        try {
            length1 = Double.parseDouble(s);
            break;
        } catch (NumberFormatException e) {
            System.out.print("Please enter a number");
        }
    }

    System.out.println("You entered : " + length1);