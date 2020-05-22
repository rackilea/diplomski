@Entity
@Table(name = "sa_s_cat")
public class SCat implements Serializable {

@Id
private int catId;
private String catSuffix;
private String catDesc;
private Lkzs lkz;
private Date cdate;
private String cuser;
...