@ManyToMany(fetch = FetchType.LAZY)
@NotFound(action = NotFoundAction.IGNORE)
@JoinTable(name = "USER_CRED", 
    joinColumns = { 
        @JoinColumn(name = "CRED_ID") }, 
    inverseJoinColumns = { 
        @JoinColumn(name = "USER_ID") })
@Filter(name="param", condition="PARAM = :param")
@BatchSize(size = Search.DEFAULT_PAGE_SIZE)
private Set<User> users;