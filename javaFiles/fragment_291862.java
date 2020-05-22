@Entity
@Audited
@Table(name = "course_schedule")
@Getter
@Setter
public class CourseSchedule{
@Id
@GenericGenerator(name = "autoincr", strategy = "native")
@GeneratedValue(generator = "autoincr")
@Column(name = "id", unique = true, nullable = false)
@Access(AccessType.PROPERTY)
protected Long id;
..........
}