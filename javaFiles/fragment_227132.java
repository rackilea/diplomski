public class EmptyElementConverter implements Converter<String>
{
    @Override
    public String read(InputNode node) throws Exception
    {
        /* Implement if required */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void write(OutputNode node, String value) throws Exception
    {
        /* Simple implementation: do nothing here ;-) */
    }
}