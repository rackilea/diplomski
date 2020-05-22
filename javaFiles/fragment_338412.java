@ManyToOne
@JoinTable(name="USER_GROUP",
    joinColumns = @JoinColumn(name = "userid", 
                              referencedColumnName = "userid"), 
    inverseJoinColumns = @JoinColumn(name = "groupid", 
                              referencedColumnName = "groupid"))
Group group;