@Entity
@Table(name = "GLOBALS")
public class Global implements Serializable {
    .
    .
    .
    @Id
    @Column(name = "NAME", length = 32)
    private String key;
    @Column(name = "INTVAL")
    private int intVal;
    @Column(name = "STRVAL", length = 4096)
    private String strVal;
    @Version
    private Long version;
    .
    .
    .
}