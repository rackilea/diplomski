for (int div = 0; div < divs; div++)
{
    for (int qtr = 0; qtr < qtrs; qtr++)
    {
        System.out.printf("Division %d, Quarter %d: $",
                        (div + 1), (qtr + 1));
        errorCheck = keyboard.nextDouble();
        while(errorCheck<0) {
            System.out.println("Positive numbers only please!");
            System.out.printf("Division %d, Quarter %d: $",
                        (div + 1), (qtr + 1));
            errorCheck = keyboard.nextDouble();
        }
        sales[div][qtr] = errorCheck;
    }
    System.out.println();
}