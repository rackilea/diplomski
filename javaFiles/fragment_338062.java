@XmlAccessorType(XmlAccessType.FIELD)
public class Account {

    @XmlElement(name = "FirstName")
    private String firstName;
    @XmlElement(name = "LastName")
    private String lastName;
    @XmlElement(name = "Country")
    private String country;
    @XmlElement(name = "PhoneNumber")
    private String phoneNumber;
    @XmlElement(name = "Email")
    private String email;
    @XmlElement(name = "Password")
    private String password;
    @XmlElement(name = "PaymentMethod")
    private PaymentMethod paymentMethod;

    // + constructors, getters, setters
}