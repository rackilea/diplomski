@MappedSuperclass
public class BaseLookup implements Serializable {

    @Id
    @Column (name="ID")
    private Long id;

    @Column (name="NAME")
    private String name;

    @Column
    private String tag;

    // ...getters, setters and ctors, etc.
}