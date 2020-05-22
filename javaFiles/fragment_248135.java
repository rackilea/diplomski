Example:
@Entity
public class Employee {
    @Id int id;
    @Transient User currentUser;
    ...
}