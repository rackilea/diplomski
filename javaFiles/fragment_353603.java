@Entity
@Table(name = "STUDENT")

public class StudentDTO
{

private long studentId;
private String studentName;
private List<Phone> studentPhoneNumbers = new ArrayList<Phone>();

@Id
@GeneratedValue
@Column(name = "STUDENT_ID")
public long getStudentId()
{
  return this.studentId;
}
@OneToMany(cascade = CascadeType.ALL)
@JoinTable(name = "STUDENT_PHONE", joinColumns = {@JoinColumn(name = "STUDENT_ID")}, inverseJoinColumns = {@JoinColumn(name = "PHONE_ID")})
public List<Phone> getStudentPhoneNumbers()
{
  return this.studentPhoneNumbers;
}