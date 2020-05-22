@Entity
@IdClass(EmploymentRecordKey.class)
public class EmploymentRecord {

    // no-arg constructor
    EmploymentRecord() { }

    // normal use constructor
    public EmploymentRecord(Long personId, Long companyId, Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyId = companyId;
        this.personId = personId;
    }

    // composite key
    @Id
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Id
    @Column(name = "person_id", nullable = false)
    private Long personId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Version
    private int versionId;

    @Override
    public String toString() {
        return
                " companyId=" + companyId +
                " personId=" + personId +
                " startDate=" + startDate +
                " endDate=" + endDate +
                " versionId=" + versionId;
    }

    // Getters/Setters

}

// Class to wrap the composite key
class EmploymentRecordKey implements Serializable {

    private long companyId;
    private long personId;

    // no arg constructor
    EmploymentRecordKey() { }

    @Override
    public int hashCode() {
        return (int) ((int) companyId + personId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof EmploymentRecordKey)) return false;
        EmploymentRecordKey pk = (EmploymentRecordKey) obj;
        return pk.companyId == companyId && pk.personId == personId;
    }

    // Getters/Setters
}