@Entity
@Table(name="RAW_SCORE")
@IdClass(TestEntityPK.class)
public class TestEntity {
    @Id private String ssn;

    @Id 
    @Column(name="SUB_TEST_CD")
    private String subTestCd;

    @Column(name="TEST_QY")
    private short testQy;

    @Column(name="SYS_REC")
    @Temporal(TemporalType.DATE)
    private Date sysRec;

    @Column(name="SYS_ID")
    private String sysId;

    // getters and setters
}