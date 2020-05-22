for (int i = 1; i <= 5; ++i)
    {
        while (true)
        {
            System.out.println("Enter the amount of sales for day " + i);
            day = keyboard.nextInt();
            if(day >= 0)
                break;
        }
            total += day; //accumulator
            sales.println("Day " + i + ": " + day);
    }