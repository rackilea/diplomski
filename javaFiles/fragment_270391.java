@Entity
@Table(name = "container_b")
public class ContainerB extends Container {

    @OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
    @Where(clause = "container_class = 'container_b'")
    private List<BinaryData> binaryData;

    public ContainerB() {
        binaryData = new ArrayList<>();
    }

    @Override
    protected List<BinaryData> getData() {
        return binaryData;
    }

    @Override
    protected String getName() {
        return "container_b";
    }
}