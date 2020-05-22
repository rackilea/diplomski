@Entity
@Table(name="vmb_mails")
@NamedQueries(
    @NamedQuery(name="getAllMails",query="SELECT  m from Mail m ORDER by m.entDate DESC ")
)
//@SequenceGenerator(name="Mails_Seq_Gen",sequenceName="vmb_mails_seq",allocationSize=1)
public class Mail implements Serializable
{
    private long id;
    private String title;
    private String fromAddr;

    public Mail()
    {

    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

...........