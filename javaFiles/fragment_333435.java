@ManyToMany(mappedBy = "following")
private Collection<User> followers = new ArrayList<>();

@ManyToMany
@JoinTable(name = "followers",
    joinColumn = @Column(name = "follower_id"),
    inverseJoinColumn = @Column(name = "following_id"))
private Collection<User> following = new ArrayList<>();