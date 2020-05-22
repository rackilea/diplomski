@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Container {

    //cannot use identity here however a table or sequence should work so long as
    //the initial value is > current max ids from all container tables.
    @Id
    @TableGenerator(initialValue = 10000, allocationSize = 100, table = "id_gen", name = "id_gen")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_gen")
    private Long id;

    public Long getId() {
        return id;
    }

    public BinaryData getBinaryData() {
        return getData().size() > 0 ? getData().get(0) : null;
    }

    public void setBinaryData(BinaryData binaryData) {
        binaryData.setContainerClass(getName());
        binaryData.setContainer(this);

        this.getData().clear();
        this.getData().add(binaryData);
    }

    protected abstract List<BinaryData> getData();

    protected abstract String getName();
}