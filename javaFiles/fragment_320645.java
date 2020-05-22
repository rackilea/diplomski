@Entity
@Table(name = "SECTIONCONTENTS", schema = "BPDMOWNER", catalog = "")
@IdClass(SectioncontentsEntityPK.class)
public class SectioncontentsEntity {

    private String sectiontitle;
    private long cdtversionid;
    private long sequence;
    private String amounttext;
    private String amounttextspanish;
    private String amounttype;
    private Byte leaderline;
    private Timestamp lastupdate;
    private String lastupdatedby;
    private Long intoc;
    private Byte eocleaderline;

    @OneToOne(mappedBy="sectionContent")
    private SectionEntity section;

    @OneToOne
    @JoinColumn(name="procedure_code_id") // just your column name for the association
    private ProcedurecodeEntity procedureCode;

    @Id
    @Column(name = "SECTIONTITLE", nullable = false, length = 30)
    public String getSectiontitle() {
        return sectiontitle;
    }