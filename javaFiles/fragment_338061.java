@XmlRootElement(name = "AccountInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountInfo {

    @XmlElement(name = "Account")
    private List<Account> accounts;

    // + constructors, getters, setters
}