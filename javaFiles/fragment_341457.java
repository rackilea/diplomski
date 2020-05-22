@SuppressWarnings("serial")
@Entity(name="PersonSimplified")
@Table(name="person")
@Inheritance(strategy=InheritanceType.JOINED)
public class PersonSimplified extends BasePerson implements Auditable, Serializable {

    public PersonSimplified() {
    }

}