@Entity
@Table(name="USERS", schema="ADMIN")
public class User implements Serializable {
//...

@ManyToOne
@JoinTable(name="USER_GROUP")
Group group;