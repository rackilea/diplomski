@MappedSuperclass
public abstract class DataObject implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @Column(name = "id")
    private int id;
}

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "entityaseq")
@Table(name = "entity_a")
public class EntityA extends DataObject { 

}

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "entitybseq")
@Table(name = "entity_b")
public class EntityB extends DataObject {

}