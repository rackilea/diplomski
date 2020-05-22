@OneToMany
@JoinTable
//filter on the target entity table
@Filter(name="betweenLength", condition=":minLength <= length and :maxLength >= length")
//filter on the association table
@FilterJoinTable(name="security", condition=":userlevel >= requredLevel")
public Set<Forest> getForests() { ... }