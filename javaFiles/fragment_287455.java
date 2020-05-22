@Entity
@Table(name = "stock")
public class Stock implements Serializable {

    @EmbeddedId
    private StockPK id;

    @MapsId("storeId")
    @ManyToOne
    private Store store;

    @MapsId("productId")
    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private int quantity;

    // Getters, setters

}