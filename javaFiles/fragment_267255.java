import javax.persistence.*;
import org.eclipse.persistence.oxm.annotations.*;

@Entity
public class Address implements Serializable {

    @Id
    private long id;

    @OneToOne
    @JoinColumn(name="ID")
    @MapsId
    @XmlInverseReference(mappedBy="address")
    private Customer customer;

}