@Root(name = "MyClass") // @Root required
@Convert(MyClass.MyClassConverter.class)
public class MyClass
{
    private int value;
    private String name;

    /* Ctor, getter, setter etc. */


    public static class MyClassConverter implements Converter<MyClass>
    {
        @Override
        public MyClass read(InputNode node) throws Exception
        {
            MyClass mc = new MyClass();

            /* Read the (int) value of 'someValue' node */
            int value = Integer.parseInt(node.getNext("someValue").getValue());
            mc.setValue(value);

            /* Same for the string */
            String name = node.getNext("someString_" + value).getValue();
            mc.setName(name);

            /* Do something with data not used in MyClass, but useable anyway */
            if( node.getNext("from") == null )
            {
                throw new IllegalArgumentException("Node 'from' is missing!");
            }

            return mc;
        }


        @Override
        public void write(OutputNode node, MyClass value) throws Exception
        {
            /* Add an attribute to the root node */
            node.setAttribute("example", "true");

            OutputNode valueNode = node.getChild("someValue");      // Create a child node ...
            valueNode.setAttribute("stack", "overflow");            // ... with an attribute
            valueNode.setValue(String.valueOf(value.getValue()));   // ... and a value

            /*
             * Converter allow a dynamic creation -- here the node names is
             * created from two values of MyClass
             */
            node.getChild("someString_" + value.getValue())     // Create another child node ...
                    .setValue(value.getName());                 // ... with a value only

            /* Create another node from scratch */
            OutputNode fromNode = node.getChild("from");
            fromNode.setValue("scratch");
            fromNode.setComment("This node is created by the converter");
        }

    }

}