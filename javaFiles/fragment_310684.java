int index, numberOfItems, itemsToBeSelected, combinations;
        int factorial, temp, result;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Number Of Items (n) : ");
        numberOfItems = scanner.nextInt();

        System.out.println("Items to be selected (r): ");
        itemsToBeSelected = scanner.nextInt();


        for (index = 1, factorial = 1; index <= numberOfItems; index++)    /* Calculate (numberOfItems) -> n! */
        {
            factorial = factorial * index;
        }

        for (index = 1, temp = 1; index <= itemsToBeSelected; index++)         /* Calculate (itemsToBeSelected) -> r! */
        {
            temp = temp * index;
        }

        for (index = 1, result = 1; index <= (numberOfItems - itemsToBeSelected); index++) /* Calculate (numberOfItems - itemsToBeSelected) -> (n-r)!*/
        {
            result = result * index;
        }

        combinations = factorial / (temp * result);
        System.out.println("Combinations : " + numberOfItems + "C" + itemsToBeSelected + " : " + combinations);