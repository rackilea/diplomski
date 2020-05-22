@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type", discriminatorType=DiscriminatorType.STRING)
public abstract class PartNumber {
...
}

@Entity
@DiscriminatorValue("Ford")
public class FordPartNumber extends PartNumber {
...
}