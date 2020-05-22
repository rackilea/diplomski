@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="company")
public class Company{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute(name="idComapny")
    @Column (name="idCompany")
    private int idcompany;

    @XmlElement(name="companyName")
    @Column (name="companyName")
    private String companyName;

   **@Embedded**
   private Department department;

   **@Embedded**
   private Worker worker;//can be removed and put in Department but result is the same
......