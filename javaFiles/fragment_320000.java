public class RootNodeConverter implements Converter<RootNode>
{
    @Override
    public RootNode read(InputNode node) throws Exception
    {
        RootNode root = new RootNode();
        final InputNode entities = node.getNext("Entities");
        InputNode child;

        while( ( child = entities.getNext() ) != null )
        {
            if( child.getName().equals("Entity") == false )
            {
                continue; //  Not an Entity
            }

            final Serializer ser = new Persister();

            switch(child.getAttribute("type").getValue())
            {
                case "foo":
                    root.getFooEntities().add(ser.read(FooEntity.class, child));
                    break;
                case "bar":
                    root.getBarEntities().add(ser.read(BarEntity.class, child));
                    break;
                default:
                    // Not a Foo nor a Bar - what now!?
                    break;
            }
        }

        return root;
    }


    @Override
    public void write(OutputNode node, RootNode value) throws Exception
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}