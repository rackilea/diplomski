@Entity
public class Shirt implements Serializable {

    @Id
    @Size(max=9)
    private String id;

    @ElementCollection
    @CollectionTable(
        name = "SHIRT_COLORS",
        joinColumns=@JoinColumn(name = "id", referencedColumnName = "id")
    )
    @Column(name="color")
    private List<String> colors = new ArrayList<String>();
    ...