int count = 0;
    for (int number=1; number <= 50; number++){

        if (number % 2 == 0)
        {
            if (count++ < 10)
                   continue;

            System.out.print(number + " " );
            System.out.println();
        }
   }