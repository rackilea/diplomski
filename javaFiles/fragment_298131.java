import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.data.validation.Constraints;

@Entity
@DiscriminatorValue("customer")
public class Customer extends User {

    @Constraints.Required
    @OneToOne(mappedBy = "customer")
    private Address address;
    private Boolean isStudent = false;

    public Customer(){}

    public static final Finder<String, Customer> find = new Finder<String, Customer>(Customer.class);
}