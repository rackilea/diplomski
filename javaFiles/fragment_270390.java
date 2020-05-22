@Entity
@Table(name = "container_a")
public class ContainerA extends Container {

    @OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
    @Where(clause = "container_class = 'container_a'")
    private List<BinaryData> binaryData;

    public ContainerA() {
        binaryData = new ArrayList<>();
    }

    @Override
    protected List<BinaryData> getData() {
        return binaryData;
    }

    @Override
    protected String getName() {
        return "container_a";
    }
}