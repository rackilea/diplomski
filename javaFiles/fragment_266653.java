@Entity
@Table(name = "address")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",discriminatorType = DiscriminatorType.INTEGER)
@NamedQueries({
@NamedQuery(name = "Address.findAll", query = "SELECT s FROM Address s where type = :type")})
public class Address implements Serializable {
    @Column(name="TYPE", insertable=false, updatable=false)
    private Integer type;
}

@Entity
@DiscriminatorValue(value = "1")
@NamedQueries({
@NamedQuery(name = "Shippingaddress.findAll", query = "SELECT s FROM Shippingaddress s")})
public class Shippingaddress  implements Serializable{}

@Entity
@DiscriminatorValue(value = "2")
@NamedQueries({
@NamedQuery(name = "Billingaddress.findAll", query = "SELECT b FROM Billingaddress b")})
public class Billingaddress extends Shippingaddress implements Serializable {}