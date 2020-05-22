public static void main(String[] args) throws IOException
{
    String dataset = readFile("filepath/dataset_3_2 (7).txt");
    String dataset1 = dataset.replace("\r","");
    String dataset2 = dataset1.replace("\n","");
    String output = reverseComplement(dataset2);
    BufferedWriter writer = null;
    try
    {
        writer = new BufferedWriter( new FileWriter("ergebnis.txt"));
        writer.write(output);

    }
    catch ( IOException e)
    {
    }
    finally
    {
        try
        {
            if ( writer != null)
            writer.close( );
        }
        catch ( IOException e)
        {
        }
    }
    System.out.println(checkForWrongCharacters(dataset));
    System.out.println("Invalid characters: " + returnOthers(dataset));
}