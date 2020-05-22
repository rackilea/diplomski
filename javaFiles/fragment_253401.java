@Entity
@IdClass(ChildId.class)
@Table(name = "CHILD")
public class Child implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent", referencedColumnName = "grandparent", columnDefinition = "varchar(20)")
    Parent parent;

    @Id
    @Column(length = 20)
    String childStringId;
}