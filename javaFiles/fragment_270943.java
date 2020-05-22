@Entity
@Check(constraints = "COL_A IS NULL OR (COL_B IS NOT NULL and COL_C IS NOT NULL)")
public class Sample {

    @Column(name = "COL_A")
    private Long a;

    @Column(name = "COL_B")
    private Long b;

    @Column(name = "COL_C")
    private Long c;

}