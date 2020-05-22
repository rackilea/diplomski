@Entity
public class Event{

@Id
@GeneratedValue
private Integer id;

@ManyToOne
@JoinColumn(name = "your_column")
private Group group;

@ManyToMany
@JoinTable(....)
private List<User> users;

...

}

@Entity
public class Group {

@Id
@GeneratedValue
private Integer id;

@OneToMany(mappedBy = "group")
@Cascade(org.hibernate.annotations.CascadeType.ALL)
private List<Event> events;

...
}