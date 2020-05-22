import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Customers {

    private List<Customer> customers;

    @XmlElement(name="customer")
    private List<Customer> getCustomers() {
        return customers;
    }

}