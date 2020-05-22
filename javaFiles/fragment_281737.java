@Entity
public class Child {

    @Id
    private Long id;

    @ElementCollection
    List<String> children = new ArrayList<>();
}