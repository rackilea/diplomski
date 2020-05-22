@Entity
@Table(name = "SECTION", schema = "BPDMOWNER", catalog = "")
@IdClass(SectionEntityPK.class)
public class SectionEntity {

    private String sectiontitle;
    private long cdtversionid;
    private String filingid;
    private String sectiondescription;
    private String defaultplanname;
    private Timestamp lastupdate;
    private String lastupdatedby;
    private String sectionheading;
    private String schedule;
    private String eocfilingid;

    @OneToOne
    @JoinColumn(name="section_contents_cdtversionid") // just your column name for the association
    private SectionContentsEntity sectionContent;

    @Id
    @Column(name = "SECTIONTITLE", nullable = false, length = 30)
    public String getSectiontitle() {
        return sectiontitle;
    }