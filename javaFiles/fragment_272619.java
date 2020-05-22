@Root(name = "data")
@Convert(FooConverter.class) // Set the converter that's used for serializing / deserializing this class
public class Foo
{
    @Element( name = "foo") // For this solution it doesn't matter what you set here
    public String foo;

    // ...


    /*
     * The converter - Implement the serialization / deserialization here.
     * You don't have to use an inner class here.
     */
    public static class FooConverter implements Converter<Foo>
    {
        @Override
        public Foo read(InputNode node) throws Exception
        {
            Foo f = new Foo();
            InputNode nextNode = node.getNext();

            while( nextNode != null )
            {
                if( nextNode.getName().equalsIgnoreCase("foo") ) // Here you pick-up the node, however it's written
                {
                    f.setFoo(nextNode.getValue());
                }

                nextNode = node.getNext();
            }

            return f;
        }


        @Override
        public void write(OutputNode node, Foo value) throws Exception
        {
            // Not required in this example.
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}