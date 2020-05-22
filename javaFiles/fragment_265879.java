@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Test implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private float behaaldCijfer, maxScore;
  private String naam;
  @Temporal(TemporalType.DATE)
  private GregorianCalendar datum;

  @ManyToOne
  @XmlElement
  private Vak vak;

  @ManyToOne
  @XmlElement
  private Student student;

  public Test() {
  }

  .....
}