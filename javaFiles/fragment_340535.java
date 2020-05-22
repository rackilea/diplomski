public class XmlParser
{
    @XmlRootElement( name = "string", namespace = "http://tempuri.org/" )
    @XmlAccessorType( XmlAccessType.FIELD )
    static class MyString
    {
        @XmlValue
        String string;
    }

    @XmlRootElement( name = "MyList" )
    @XmlAccessorType( XmlAccessType.FIELD )
    static class MyList
    {
        @XmlElement( name = "Obj" )
        List<String> objs = new ArrayList<>();
    }

    public static void main( String[] args ) throws JAXBException
    {
        String s = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                + "<string xmlns=\"http://tempuri.org/\">&lt;?xml version=\"1.0\" encoding=\"utf-8\" ?&gt;&lt;MyList&gt;&lt;Obj&gt;Im obj 1&lt;/Obj&gt;&lt;Obj&gt;Im obj1&lt;/Obj&gt;&lt;/MyList&gt;</string>";

        JAXBContext context = JAXBContext.newInstance( MyString.class, MyList.class );
        Unmarshaller unmarshaller = context.createUnmarshaller();

        MyString myString = (MyString) unmarshaller.unmarshal( new StringReader( s ) );
        MyList myList = (MyList) unmarshaller.unmarshal( new StringReader( myString.string ) );

        System.out.println( myList.objs );
    }
}