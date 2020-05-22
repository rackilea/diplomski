@Entity
@Table(name="secound")
public class Secound implements Serializable {


    @Id
    @Column(name="main_id", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="main"))
    private int secId;

    public String getSecoundString() {
        return secoundString;
    }

    public void setSecoundString(String secoundString) {
        this.secoundString = secoundString;
    }

    private String secoundString;
    public int getSecId() {
        return secId;
    }

    public void setSecId(int secId) {
        this.secId = secId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="sec_id")
    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }



}`