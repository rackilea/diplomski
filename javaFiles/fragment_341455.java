@SuppressWarnings("serial")
@Entity(name="PersonSimplified")
@Table(name="person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PersonSimplified extends BaseEntity implements Auditable, Serializable {
    //Lots of stuff
}