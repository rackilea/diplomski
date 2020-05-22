@Plugin(name = "NewCustLayout", category = Node.CATEGORY, elementType = Layout.ELEMENT_TYPE, printObject = true)
public class NewCustLayout  extends AbstractStringLayout
{
    protected NewCustLayout( Charset charset )
    {
        super( charset );
    }

    @Override public String toSerializable( LogEvent event )
    {
        return null;
    }
}