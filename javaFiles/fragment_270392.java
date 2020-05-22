@Entity
@Table(name = "binary_data")
public class BinaryData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @Any(metaColumn = @Column(name = "container_class"))
    @AnyMetaDef(idType = "long", metaType = "string", metaValues = {
            @MetaValue(targetEntity = ContainerA.class, value = "container_a"),
            @MetaValue(targetEntity = ContainerB.class, value = "container_b") })
    @JoinColumn(name = "entity_id")
    private Container container;

    @Column(name = "container_class")
    private String containerClass;

    public Long getId() {
        return id;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public String getContainerClass() {
        return containerClass;
    }

    public void setContainerClass(String containerClass) {
        this.containerClass = containerClass;
    }
}