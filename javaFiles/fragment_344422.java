@ManyToMany(cascade=CascadeType.REMOVE)
@JoinTable(name="up_votes")
public List<User> upVotes = new ArrayList<User>();

@ManyToMany(cascade=CascadeType.REMOVE)
@JoinTable(name="down_votes")
public List<User> downVotes = new ArrayList<User>();