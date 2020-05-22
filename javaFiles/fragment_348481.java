int sum = 0;
    int num;
    int i = 0;
    System.out.print("Enter number: ");
    num = sc.nextInt();
    do{
    sum += i;
    i++;
    }
    while ( i <=num );

    System.out.println("The sum is " + sum);