public class User implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue
private int id;


@ManyToMany(cascade={CascadeType.ALL})
@JoinTable(name="USER_COURSE", joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")},
inverseJoinColumns={@JoinColumn(name="COURSE_ID", referencedColumnName="COURSE_ID")})
private List<Course> courses;

}