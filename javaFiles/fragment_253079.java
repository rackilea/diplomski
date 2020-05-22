@XmlRootElement(name="Department")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Embeddable
@Table(name="Department")
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute(name="idDepartment")
    @Column (name="idDepartment")
    private int idDepartment;

    @XmlElement(name="departmentName")
    @Column (name="deparmentName")
    private String departmentName;