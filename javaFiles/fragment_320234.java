@Entity 
@Table(...) 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Vehicle { ... }

@Entity
@DiscriminatorValue("...")
public class Car extends Vehicle { ... }

@Entity
@DiscriminatorValue("...")
public class Truck extends Vehicle { ... }