@Entity
@SequenceGenerator(name="seq", initialValue=18000, allocationSize=100)
public class EntityWithSequenceId {

    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @Id long id;

}