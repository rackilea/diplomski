@Root(name = "listdata")
@Convert(ListData.ListDataConverter.class)
class ListData
{
    @Attribute
    private StaticData ref;
    @Element
    private String name;

    // ...

    // Converter implementation
    static class ListDataConverter implements Converter<ListData>
    {

        @Override
        public ListData read(InputNode node) throws Exception
        {
            /*
             * In case you also want to read, implement this too ...
             */
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void write(OutputNode node, ListData value) throws Exception
        {
            node.setAttribute("ref", value.ref.getId());
            node.getChild("name").setValue(value.name);
        }
    }
}