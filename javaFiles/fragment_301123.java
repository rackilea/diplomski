@Entity
@Table(name = "enrollment")
@Audited
public class Enrollment implements Serializable {
    //...
    @Column(name = "enrollment_status_id", nullable = false)
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Audited(withModifiedFlag = true, modifiedColumnName = "enrollment_status_id_modified")
    private EnrollmentStatus status;

    // getters setters etc
    //...
}