@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="emptype",
    discriminatorType=DiscriminatorType.STRING
)
public abstract class Employee { ... }

@Entity
@DiscriminatorValue("MGR")
public class Manager extends Employee { ... }