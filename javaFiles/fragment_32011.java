try
{
    // A String variable to println after the reading.
    String consoleResume = "";
    scanIn = new Scanner ( new BufferedReader(new FileReader(filepath)));           
    while(scanIn.hasNextLine())
    {


        InputLine = scanIn.nextLine();
        String[] InArray = InputLine.split(",");
        for(int x = 0; x<InArray.length; x++)
        {
            myArray[Rowc][x] = InArray[x];
        }
        // There is a transaction when you have 3 strings in InArray
        if (InArray.length()==3)
            consoleResume+=InArray[1]+":"+InArray[2]+"\n"; 
        Rowc++;

    }
    System.out.println(consoleResume);

}catch (Exception e)
{
    System.out.println("Error");
}