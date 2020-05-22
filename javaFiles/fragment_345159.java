try
    {
        Scanner file = new Scanner(new File("file.txt"));
        String str = str.nextLine();
        System.out.print("Enter search ");
        Num = input.nextInt();

        if ( Num == 0 )
        {
            System.out.println("Enter search for: ");
            String Value = input.next();

            while (file.hasNextLine())
            {
                final String lineFromFile = file.nextLine();
                if(lineFromFile.contains(Value))
                {
                    System.out.println("file.txt");
                    System.out.println(lineFromFile);
                    break;
                }