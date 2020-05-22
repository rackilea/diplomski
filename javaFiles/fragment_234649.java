try 
    {
        Scanner input = new Scanner(System.in);
        File file = new File("ComputerText.txt");

        input = new Scanner(file);

        String contents;
        while (input.hasNext()) 
        {
            contents = input.next();
        }
        input.close();

    } 
    catch (Exception ex) 
    {
    }