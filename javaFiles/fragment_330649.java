@Entity
public class Parent {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="parent")
    private Set<Child> children;