class Address {
    @XmlElement(name="Name")
    private String name;
    @XmlElement(name="ID")
    private String id;
    public String getName() {
        return name;
    }
    public String getID() {
        return id;
    }
}

public class Test { 

    public static void main(String[] args) throws Exception {
        Address addr = JAXB.unmarshal(new File("address.xml"), Address.class);
    }
}