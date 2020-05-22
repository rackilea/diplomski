@Entity
@Immutable
public class ProductView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

    @Column(name = "product_code")
    private String code;
    ...
}