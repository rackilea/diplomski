@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_DISCRIMINATOR")
public class A extends SomeClass implements SomeInteface {


…
@Id
@Column(name = "ID", nullable = false, precision = 0)
public Integer getPk() {
    return super.getPk();
}
…