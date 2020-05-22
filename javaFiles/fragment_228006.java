@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="addresstype",
    discriminatorType= DiscriminatorType.STRING)
public abstract class Address {
    ... common attributes here
}

@Entity
@DiscriminatorValue("home")
public class HomeAddress extends Address {
...

}

@Entity
@DiscriminatorValue("work")
public class WorkAddress extends Address {
...

}