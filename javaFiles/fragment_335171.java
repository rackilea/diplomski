public class SimpleBean
{
private final String name = "SimpleBean";
private int size;

public String getName()
{
    return this.name;
}

public int getSize()
{
    return this.size;
}

public void setSize( int size )
{
    this.size = size;
}

public static void main( String[] args )
        throws IntrospectionException
{
    BeanInfo info = Introspector.getBeanInfo( SimpleBean.class );
    for ( PropertyDescriptor pd : info.getPropertyDescriptors() )
        System.out.println( pd.getName() );
}
}