@Entity
@Table(name="JOB")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id 
    @SequenceGenerator(name="person_seq", sequenceName="SEQ_PERSON",initialValue=1,allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="person_seq")
    @Column(name="JOB_SERIAL")
    private int id;

    @Column(name="JOB_CATAGORY",nullable=false,length=200,unique=true)
    private String catagory;


    /*   The problem was inside this block */


    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn (name="JOB_AUTHID", nullable = false)
    private Authorization authorization;                                 

    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn (name="JOB_JOBFILTERID", nullable = false)
    private JobFilteration jobfilteration;