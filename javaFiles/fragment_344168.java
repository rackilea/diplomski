@Entity
@CheckAtLeastOneNotNull(fieldNames={"fieldA","fieldB"})
public class Reward {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer fieldA;
    private Integer fieldB;

    [...] // accessors, other fields, etc.
}