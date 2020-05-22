Scanner in = new Scanner(System.in);

        System.out.print("Enter an integer, or Q to quit: ");
        int largest = Integer.MIN_VALUE;

        while (in.hasNextInt())
        {           
            int input = in.nextInt();
            if (input > largest)
            {
                largest = input;
            }

            System.out.print("Enter an integer, or Q to quit: ");

        }

        System.out.println(largest);