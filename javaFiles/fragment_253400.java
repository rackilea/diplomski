@Entity
@Table(name = "PARENT")
public class Parent implements Serializable {
    @Id
    String id;

    @OneToOne
    @JoinColumn(name = "grandparent")
    @MapsId
    Grandparent grandparent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    List<Child> child;
}