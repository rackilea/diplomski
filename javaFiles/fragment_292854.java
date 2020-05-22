@Entity
@Table(name = "sa_s_subcat")
public class SSubCat implements Serializable {

@Id
private int subcatId;
private int catId;
private String subcatSuffix;
private String subcatDesc;
private boolean subcatShowProd;
private boolean subcatShowComp;
private boolean subcatShowQual;
private boolean subcatShowDetail;
private Lkzs lkz;
private Date cdate;
private String cuser;
@ManyToOne(optional = false)
@JoinColumn(name = "catId", insertable = false, updatable = false)
private SCat cat;
...