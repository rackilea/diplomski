@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = { "username", "site" }))
} @Entity
public class User{
// etc
}