try
{
    scanIn = new Scanner ( new BufferedReader(new FileReader(filepath)));           
    while(scanIn.hasNextLine())
    {


        InputLine = scanIn.nextLine();
        String[] InArray = InputLine.split(",");
        for(int x = 0; x<InArray.length; x++)
        {
            myArray[Rowc][x] = InArray[x];
        }
        // There is a transaction when you have 3 strings in inArray
        if (InArray.length()==3)
            System.out.println(InArray[1]+":"+InArray[2]); 
        Rowc++;

    }


}catch (Exception e)
{
    System.out.println("Error");
}