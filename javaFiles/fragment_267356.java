public class Customer
{
    private String  name = "";
    @XmlElement(name="grantA");
    private Grant grantA;

    @XmlElement(name="grantB");
    private Grant grantB;

    @XmlElement(name="grantC");
    private Grant grantC;

    //rest of the code
}