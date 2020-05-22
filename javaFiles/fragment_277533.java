class BufferedReaderFactoryImpl implements BufferedReaderFactory
{
    @Override
    public BufferedReader createBufferedReader(String fileName) throws IOException
    {
        return new BufferedReader(new FileReader(fileName));
    }
}