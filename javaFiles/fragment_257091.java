@Entity
public class Stock {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
@Entity
@Data
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
@Entity
@Data
public class StockProduct {
    @EmbeddedId
    private StockProductPk id;

    @ManyToOne
    @MapsId("productId")
    private Product product;
    @ManyToOne
    @MapsId("stockId")
    private Stock stock;

    @ManyToOne
    private Category category;
}
@Embeddable
@Data
public class StockProductPk implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long stockId;
    private Long productId;
}