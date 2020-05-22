Scanner scan = new Scanner(System.in);
    System.out.println("Enter number : ");
    int input = scan.nextInt ();
    int sum = 0;

    for (int loop = 1; loop <= 10; loop++) {
        int out = loop * input;
        sum += out;
        System.out.println(out);
    }

    // and down
    for (int loop = 10; loop >= 1; loop--) {
        int out = loop * input;
        System.out.println(out);
    }

    System.out.println("sum is "+ sum);