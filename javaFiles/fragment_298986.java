@Entity
@Table(name = "Nodos")
public class StopDTO implements java.io.Serializable{

    /*
     * Atributos
     */
    private static final long serialVersionUID = 8171715812406080593L;

    @Id
    @Column(name = "Id", insertable = false, updatable = false)
    private Integer id;
    @Id
    @Column(name = "Tipo", insertable = false, updatable = false)
    @Type(type = "com.mycompany.usertype.TipoNodoUserType")
    private Short tipo;
    @Column(name = "Nombre", insertable = false, updatable = false)
    private String nombre;
    @Column(name = "PosX", insertable = false, updatable = false)
    @Type(type = "com.mycompany.usertype.CoordenadaUserType")
    private Float posx;
    @Column(name = "PosY", insertable = false, updatable = false)
    @Type(type = "com.mycompany.usertype.CoordenadaUserType")
    private Float posy;
    @Column(name = "Label", insertable = false, updatable = false)
    private String label;
    ...
    // Don't forget to code an empty constructor, setters/getters for every attribute and implementing hashCode and equals methods (as we're implementing Serializable interface).