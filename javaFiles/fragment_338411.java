@Entity
@Table(name="GROUPS", schema="ADMIN")
public class Group implements Serializable {
//...

@OneToMany(mappedBy="group")
Set<User> users;