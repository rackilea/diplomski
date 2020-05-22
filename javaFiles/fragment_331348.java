@Entity
@Table(name = "EnrolledInfo")
public class EnrolledInfo implements Serializable {

    @Id
    @Column(name="STUDENT_ID")
    private Long studentId;

    @OneToOne(fetch = FetchType.Eager)
    @PrimaryKeyJoinColumn(name="STUDENT_ID", referencedColumnName="STUDENT_ID")
    @JsonBackReference
    private Student student;