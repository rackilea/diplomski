Scanner myInput = new Scanner(System.in);
    // correct declaration
    int a;
    // initialize sum with zero.
    int sum=0;
    System.out.print("Enter first integer: ");
    a = myInput.nextInt();

    //for simplicity,start value n from a and loop until n reaches a+100.
    for (int n = a; n <= 100+a; n++) {
        sum = sum + n;
    }
    System.out.println("Sum = "+ sum);