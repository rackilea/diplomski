@Entity
 @Table(name = "items")
 public class InvoiceItem {

 ...

     @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH})
     @JoinColumn(name = "invoice_id")
     @JsonIgnore
     private Invoice invoice;