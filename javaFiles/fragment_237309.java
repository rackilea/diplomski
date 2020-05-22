@Entity
@XmlRootElement(name = "node")
public class Node {
    @Id
    private int id;
    private String name;
    @ElementCollection
    @CollectionTable(
        name="NODE_ADDRESS",
        joinColumns=@JoinColumn(name="NODE_ID")
    )
    @Column(name = "ADDRESS")
    private List<String> address;

    // Getters + Setters
}