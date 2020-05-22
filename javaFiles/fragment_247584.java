@Entity
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // getters, setters, 
    // AND hashCode and equals using the id field
}