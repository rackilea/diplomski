@Entity
public class CompositeKey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = ReferencedEntity.class)
    private ReferencedEntity key1;

    @Basic
    private Integer key2;

}