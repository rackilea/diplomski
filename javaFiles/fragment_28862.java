try
     {
        //your code
        return buildingsArr;
     }
     catch(IOException e)
     {
        e.printStackTrace();
     }
     catch(ClassNotFoundException e)
     {
        Console.printPrompt("ArrayList<Building> class not found.");
        e.printStackTrace();
     }
    finally{
        Console.printPrompt("Closing file...");
        close(in);
        close(fileIStream);
    }