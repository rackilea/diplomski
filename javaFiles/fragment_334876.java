@Entity
@Table(name = "ORDERS")
public class Order {

    @Column(columnDefinition = "serial")
    private @Id Integer id;
    private @NotNull @Email String ownerEmail;

    private @NotNull Integer offerId;

    @Column(insertable=false , updateable=false)
    private Offer offer;
}