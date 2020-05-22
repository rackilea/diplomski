@MappedSuperclass // or @Entity
public abstract class Supplier extends Person { ... }

@Entity
@Table(name = "NATIONAL_SUPPLIER")
@DiscriminatorValue("1")
public class National extends Supplier { ... }

@Entity
@Table(name = "FOREIGN_SUPPLIER")
@DiscriminatorValue("2")
public class Foreign extends Supplier { ... }