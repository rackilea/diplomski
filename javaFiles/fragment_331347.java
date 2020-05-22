@Entity
@Table(name = "EnrolledInfo")
public class EnrolledInfo implements Serializable {

    @Id
    private Long studentId;

    @OneToOne(fetch = FetchType.Eager)
    @Id
    @JsonBackReference
    private Student student;