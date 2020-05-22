Scanner height = new Scanner(System.in);
        System.out.println("Please choose a number: ");
        z = height.nextInt();
        while((z < 0))
        {
            System.out.println("Wrong number, try again: ");
            z = height.nextInt();

        }

        return z;