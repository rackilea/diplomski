@SuppressWarnings("serial")
@Entity(name="Person")
@Table(name="person")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person extends BasePerson implements Auditable, Serializable {
    //Slow stuff
}