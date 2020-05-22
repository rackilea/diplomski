@OneToMany(cascade={CascadeType.ALL})
@JoinTable(name="session_aggregategroupmap")
private Map<String, GroupInfo> aggregateGroupMap; 
@OneToMany(cascade={CascadeType.ALL})
@JoinTable(name="session_computationgroupmap")
private Map<String, GroupInfo> computationGroupMap;