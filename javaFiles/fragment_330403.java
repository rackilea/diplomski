@Entity
@Table(name = "ADDRESS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="ADDRESS_TYPE",
    discriminatorType=DiscriminatorType.INTEGER
)
@DiscriminatorValue("null")

public class Address  {