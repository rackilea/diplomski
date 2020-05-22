Scanner scanner = new Scanner(System.in);

    int number = 0;
    int sum;
    int entries = 0;
    boolean positive;

    do
    {
        sum = 0;
        do
        {
            System.out.print("Input a number: ");
            number = scanner.nextInt();

            if (number < 0)
            {
                 positive = false;
            }
            else
            {
                 positive = true;
            }

            scanner.nextLine();
        }
        while ((positive == false) || (number < 20) || (number > 100));

        System.out.println("Number input OK [ " + number + " ]"
            + "\n\nLet's go to the next phase!\n\n"
            + "The odd numbers until [ " + number + " ] are: ");

        for (int i = 0; i <= number; i++)
        {
            if (i % 2 != 0)
            {
                System.out.print(i + " ");
                sum = sum + i;
            }
        }
        System.out.println("\nAnd the sum of the odd numbers until [ " + number + " ] are: " + sum);
    }
    while (++entries < 2);

}