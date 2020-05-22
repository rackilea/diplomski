//TestApi parts
@GET
@Path ( "test" )
@Produces ( "application/json" )
public Demo getDemo () {
    Demo d = new Demo ();
    d.id = 1;
    d.name = "test";
    return d;
}

//client config for a TestApi interface
List providers = new ArrayList ();
JSONProvider jsonProvider = new JSONProvider ();
Map<String, String> map = new HashMap<String, String> ();
map.put ( "http://www.myserviceapi.com", "myapi" );
jsonProvider.setNamespaceMap ( map );
providers.add ( jsonProvider );
TestApi proxy = JAXRSClientFactory.create ( url, TestApi.class, 
    providers, true );

Demo d = proxy.getDemo ();
if ( d != null ) {
    System.out.println ( d.id + ":" + d.name );
}

//the Demo class
@XmlRootElement ( name = "demo", namespace = "http://www.myserviceapi.com" )
@XmlType ( name = "demo", namespace = "http://www.myserviceapi.com", 
    propOrder = { "name", "id" } )
@XmlAccessorType ( XmlAccessType.FIELD )
public class Demo {

    public String name;
    public int id;
}