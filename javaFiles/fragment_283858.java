@MappedSuperclass // or @Entity
public abstract class Client extends Person { ... }

@Entity
@Table(name = "NATIONAL_CLIENT")
@DiscriminatorValue("3")
public class National extends Client { ... }

@Entity
@Table(name = "FOREIGN_CLIENT")
@DiscriminatorValue("4")
public class Foreign extends Client { ... }