@SuppressWarnings("serial")
@Entity(name="Person")
@Table(name="person")
public class Person extends PersonSimplified implements Auditable, Serializable {
    //Some slow stuff
}