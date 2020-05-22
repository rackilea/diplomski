@Entity
@Table(name = "PROMOTIONS")
@Audited
public class PromotionEntity implements Comparable<PromotionEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "discount", nullable = false)
    private Integer discount;

    @Column(name = "message", nullable = false)
    private String message;

    ...
}