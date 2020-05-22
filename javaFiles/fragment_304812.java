package forum8198945;

import java.util.Date;  
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Customer {

    private String name;
    private Customer customerReference;
    private Integer quantity;
    private Date createdAt;

    @XmlElement(nillable=true, type=Object.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(nillable=true, type=Object.class)
    public Customer getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(Customer customerReference) {
        this.customerReference = customerReference;
    }

    @XmlElement(nillable=true, type=Object.class)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @XmlElement(nillable=true, type=Object.class)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}