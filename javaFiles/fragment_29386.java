Scanner scanner = new Scanner(System.in);
    if (scanner.hasNext())
    {
        final String input = scanner.next();
        try
        {
            int num = Integer.parseInt(input, 2);
        }
        catch (NumberFormatException error)
        {
            System.out.println(input + " is not a binary number.");
            //OR You may exit here, if you don't want to continue
        }
    }