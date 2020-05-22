Scanner in = new Scanner(System.in);

    System.out.print("How many times? ");
    int numOfTimes = in.nextInt();

    double hrTotal = 0;
    double minTotal = 0;

    PrintWriter p = new PrintWriter("Times.txt");

    for (int i = 1; i <= numOfTimes; i++) {

        System.out.println("\nEnter time in military time notation: ");
        System.out.print("Hour  ");
        double hrs1 = in.nextDouble();
        System.out.print("Minute  ");
        double min1 = in.nextDouble();

        hrTotal += hrs1;
        minTotal += min1;
        String hrs = String.valueOf(hrs1);
        String min = String.valueOf(min1);
        p.println(hrs.substring(0, hrs.indexOf(".")) + min.substring(0,min.indexOf(".")));
    }
    p.close();