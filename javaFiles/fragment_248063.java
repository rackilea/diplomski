@Entity
@Table(name = "orderLine")
public class OrderLine implements Serializable{

    private static final long serialVersionUID = -851110991599534263L;

    @AttributeOverrides(value = 
            {@AttributeOverride(column = @Column(name="productCode"), name = "productCode"),
            @AttributeOverride(column = @Column(name="orderNumber"), name = "orderNumber")})
    @EmbeddedId
    private LineID pk;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("productCode")
    private Product product;

    private int quantity;

    private double unitPrice;

    private double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("orderNumber")
    private SalesOrder salesOrder;


    @Override
    public boolean equals(Object obj) {

        try {
            LineID line = (LineID) obj;
            return (this.getSalesOrder().getOrderNumber()
                    .equals(line.getOrderNumber()) && this.getProduct()
                    .getCode().equals(line.getProductCode()));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (this.getProduct().getCode() + "" + this.getProduct().getCode()).hashCode();
    }
}