@Entity
@Table(name = "PROCEDURECODE", schema = "BPDMOWNER", catalog = "")
public class ProcedurecodeEntity {
    private long procedurecodeid;
    private String procedurecode;
    private String proceduredescription;
    private String proceduredescriptionspanish;
    private String proceduredescriptiondbb;
    private String amounttext;
    private String amounttextspanish;
    private String amounttype;
    private String procedurecodecomment;
    private String procedurecoderemark;
    private Timestamp lastupdate;
    private String lastupdatedby;
    private Long benefitid;

    @OneToOne(mappedBy="procedureCode")
    private SectionContent sectionContent;

    @Id
    @Column(name = "PROCEDURECODEID", nullable = false, precision = 0)
    public long getProcedurecodeid() {
        return procedurecodeid;
    }