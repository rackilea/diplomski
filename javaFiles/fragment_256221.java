public class Box extends BasicData implements Serializable {
....

//bi-directional many-to-many association to User
@ManyToMany(mappedBy="boxs")
private Set<User> users;

//bi-directional many-to-one association to BoxUser
@OneToMany(mappedBy="box")
private Set<BoxUser> boxUsers;