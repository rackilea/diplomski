@Entity
@Table(name = "entity_header")
public class EntityHeader implements Serializable{

    /**
     * Serial
     */
    private static final long serialVersionUID = 1710372870796468955L;

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn
    private Entidad entity;

    @ManyToOne
    @JoinColumn
    private HeaderType headerType;

    private String value;

    //Getters and setters
}