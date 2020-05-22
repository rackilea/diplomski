class CsvFileReader
{
    private final BufferedReaderFactory factory;

    public CsvFileReader(BufferedReaderFactory factory)
    {
        this.factory = factory;
    }

    public List<Student> readCsvFile(String fileName)
    {

        BufferedReader fileReader = null;
        try
        {
            fileReader = factory.createBufferedReader(fileName);
            ...
        }
        catch(IOException e)
        {
            ...
        }
        finally
        {
            ...
        }
        return new LinkedList<>();
    }
}