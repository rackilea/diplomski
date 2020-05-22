class Event{

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "EVENT_USER", 
               joinColumns = { @JoinColumn(name = "EVENT_ID") }, 
               inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
    private Set<Users> users = new HashSet<Users>();

}