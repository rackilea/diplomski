import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.avaje.ebean.Model;

import play.data.validation.Constraints;

@Entity
public class Address extends Model {

    @Id
    @Constraints.Required
    @GeneratedValue
    @Constraints.Max(15)
    private Long addressId;
    @Constraints.Required
    private String unitNumber;
    @Constraints.Required
    private String streetName;
    private String communityName;
    private Boolean isCommunity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Customer customer;

    public Address(){}

    public static Finder<String, Address> find = new Finder<String, Address>(Address.class);
}