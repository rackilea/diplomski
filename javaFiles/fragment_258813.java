public class WriteFile
{
    private Formatter x;
    private String fileName;

    public WriteFile(String address) throws FileNotFoundException
    {
        fileName = address;
        try
        {
            x = new Formatter(fileName);
        } catch (Exception e)
        {
            throw new FileNotFoundException("Could not write to file.");
        }
    }

    public void writeFile(ArrayList<String> myWords)
    {
        for (int index = 0; index < myWords.size(); index++)
            x.format("%s%s", myWords.get(index), System.lineSeparator());

        // now you are done writing so close the file.

        x.close();
    }
}