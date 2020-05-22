@Embeddable
public class StockPK implements Serializable {

    @Column(name = "store_id")
    private int storeId;

    @Column(name = "product_id")
    private String productId;

    // Getters, setters, hashCode, equals

}