@ManyToMany
@JoinTable(name="tbl_friends",
 joinColumns=@JoinColumn(name="personId"),
 inverseJoinColumns=@JoinColumn(name="friendId")
)
private List<User> friends;

@ManyToMany
@JoinTable(name="tbl_friends",
 joinColumns=@JoinColumn(name="friendId"),
 inverseJoinColumns=@JoinColumn(name="personId")
)
private List<User> friendOf;