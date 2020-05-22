Scanner sc = new Scanner(System.in);

    int sum = 0;
    int count = 0;
    int n = 0;

    do {
        System.out.println("Enter next number(-1 to exit): ");
        n = sc.nextInt();
        System.out.println("Value is :" + n);

        if(n != -1)
        {
            count++;
            sum = sum + n; 
        }

    }while ( n != -1);

    sc.close();
    System.out.println("Mean is: " + (double) sum/count);
}