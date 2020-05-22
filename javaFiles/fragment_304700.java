static void readFromCsvFile(String sFileName, User user) throws FileNotFoundException { 
   String thisLine;
   BufferedReader reader = new BufferedReader(new FileReader(sFileName));
    try
    {

       thisLine = reader.readLine();
       System.out.print(thisLine);

       while((thisLine = reader.readLine()) != null)               
           {
               thisLine = thisLine.trim();
               String username = thisLine.split(" ")[0];
                if (user.displayUserName().equals(username))
                {
                System.out.print("\nUser <-" + user.displayUserName() + " -> exists!");
                break;   // break the loop
                }                    
           }

    }
    catch(IOException e)
    {
        System.out.print("\nUser does not exist\n"); 
        e.printStackTrace();
    } 
    finally {
        try {
            reader.close();
        } catch (IOException e) { /* ignore */ }
    }
}