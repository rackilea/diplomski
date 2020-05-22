@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = STRING, length = 1)
@DiscriminatorValue("?")
@Entity

public abstract class Project {
    :
    :
}

@DiscriminatorValue("P")
public class ProjectCodeProject extends Project {
    :
    :
}