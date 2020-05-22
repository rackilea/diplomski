public class ExampleConverter implements Converter
{
    @Override
    public Object read(InputNode node) throws Exception
    {
        /* TODO: Deserialize your class here (if required). */
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void write(OutputNode node, Object value) throws Exception
    {
        final Example val = (Example) value;
        final List<Object> l = val.getValueUnion();

        if( !l.isEmpty() ) // if there are elements, insert their nodes
        {
            for( Object obj : l )
            {
                node.getChild("values").setValue(obj.toString());
            }
        }
        else
        {
            node.getChild("values").setValue(""); // this creates <values></values> if list is empty
        }
        node.setValue(val.getText()); // Set the text (1)
    } 
}