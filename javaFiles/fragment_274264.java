@Entity
public class A implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private A parent;
    @OneToMany(mappedBy="parent")
    private Collection<A> children;

    // Getters, Setters, serialVersionUID, etc...
}