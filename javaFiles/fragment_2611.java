@Entity
public class PaymentMethod  extends Model {
    ...
    @Column(nullable = false)
    @ManyToOne
    public Customer customer;
}