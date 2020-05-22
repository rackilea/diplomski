Scanner input = new Scanner(System.in);
    int num, den;

    do {
        System.out.println("Please enter the numerator: ");
        num = input.nextInt();
        System.out.println("Please enter the denominator: ");
        den = input.nextInt();
        if (den!=0)
            System.out.println("Decimal is " + result(num, den));
        else
            System.out.println("Denominator shouldnt be 0");
    } while (den == 0);
    input.close();