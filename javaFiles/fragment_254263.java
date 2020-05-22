public class Event {
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="events")
    private Set<User> users = new HashSet<>();
}

public class User {
    @ManyToMany
    @JoinTable(
      name="event_users",
      joinColumns=@JoinColumn(name="user_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="event_ID", referencedColumnName="ID"))
    private Set<Event> events = new HashSet<>();
}