@Entity
@SecondaryTable(name="student_task")
public class Task implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(table = "student_task", name = "student_id")
  private Student author;

  @ManyToOne(optional = false)
  @JoinColumn(table = "student_task", name = "teacher_id")
  private Teacher curator;

  //getters and setters

}