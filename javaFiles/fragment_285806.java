@Entity
@Table(name = "Invoice")
public class Invoice {
    @EmbeddedId
    private InvoiceId invoiceId;
    @ManyToOne
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    private Customer customer;
    @Column(name = "price", nullable = false)
    private double price;
}

@Embeddable
class InvoiceId implements Serializable {
    //Composite PK
    @Column(name = "customerId")
    private int customerId;
    @Column(name = "date")
    private Date date;
}