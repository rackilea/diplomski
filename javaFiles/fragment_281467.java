package blog.immutable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import blog.immutable.adpater.CustomerAdapter;

@XmlRootElement(name="purchase-order")
public class PurchaseOrder {

    private Customer customer;

    @XmlJavaTypeAdapter(CustomerAdapter.class)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}