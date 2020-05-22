@Entity
@Table(name = "CHAIRS")
public class ChairEntity {

    @Id
    @GeneratedValue(generator = MyGenerator.generatorName)
    protected String id;

    // rest of the entity
}