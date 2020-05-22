while (num < 2 || num > 10) {
            System.out.println("Enter a valid number please.");
            num = keyNum.nextInt();
        }
        for (int a = 0; a < num + 1; a++)
        {
            System.out.print(" ");
        }
        for (int b = 0; b < num; b++)
        {
            System.out.print("*");
        }
        for (int c = 0; c < num; c++)
        {
            System.out.println("");
            for (int d = num; d > c; d--)
            {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int e = num * 2; e < (num * 3) + (c *2);  e++)
            {
                System.out.print(" ");
            }
            System.out.print("*");
        }
        for (int f = 0; f < num; f++)
        {
            System.out.println("");
            System.out.print("*");
            for (int g = 0; g < num * 3; g++)
            {
                System.out.print(" ");
            }
            System.out.print("*");
        }

        for (int h = 1; h <= num; h++)
        {
            System.out.println("");
            for (int i = 0; i < h; i++)
            {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < (num * 3) - (h * 2) ; j++)
            {
                System.out.print(" ");
            }
            System.out.print("*");
        }
        System.out.println("");
        for (int k = 0; k < num + 1; k++)
        {
            System.out.print(" ");
        }
        for (int l = 0; l < num; l++)
        {
            System.out.print("*");
        }