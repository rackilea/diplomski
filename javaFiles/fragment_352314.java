@Root(name = "addresses")
public class Addresses {

    @ElementList(inline = true, entry = "address", required = false, type = Address.class)
    private List<Address> addresses = new ArrayList<Address>();

public class Address {

    @Element(required = false)
    private String name;
    @Element(required = false)
    private String city;
    @Element(required = false)
    private String street;
    @ElementMap(entry = "phone", key = "type", attribute = true, inline = true)
    private Map<String, String> phones;
    @Path("./documents")
    @ElementMap(entry = "document", key = "type", attribute = true, inline = true) //changed this line
    private Map<String, String> documents = new HashMap<String, String>();