public class SimpleframeworkTest
{
    // ...

    @Root(name = "container", strict = false)
    @Convert(NullawareContainerConverter.class)
    public static class Container
    {
        static final Serializer ser = new Persister(new AnnotationStrategy());

        // ...

        public String toXml() throws Exception
        {
            StringWriter sw = new StringWriter();
            ser.write(this, sw);
            return sw.toString();
        }

        public static Container toObject(String xml) throws Exception
        {
            return ser.read(Container.class, xml);
        }

        // ...
    }


    static class NullawareContainerConverter implements Converter<Container>
    {
        final Serializer ser = new Persister();

        @Override
        public Container read(InputNode node) throws Exception
        {
            final Container c = new Container();
            c.id = Integer.valueOf(node.getAttribute("id").getValue());
            c.params = new ArrayList<>();
            InputNode n;

            while( ( n = node.getNext("object")) != null )
            {
                /* 
                 * If the value is null it's added too. You also can add some
                 * kind of null-replacement element here too.
                 */
                c.params.add(n.getValue());
            }

            return c;
        }

        @Override
        public void write(OutputNode node, Container value) throws Exception
        {
            ser.write(value.id, node);

            for( Object obj : value.params )
            {
                if( obj == null )
                {
                    obj = ""; // Set a valid value if null
                }
                // Possible you have to tweak this by hand
                ser.write(obj, node);
            }
        }

    }

}