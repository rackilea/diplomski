@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vak implements Serializable {

private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String naam;

  @OneToMany(mappedBy = "vak", cascade = CascadeType.ALL)
  @XmlElement
  @XmlInverseReference(mappedBy = "vak")
  private List<Test> testen = new ArrayList<>();

  public Vak() {
  }

  public Vak(String naam) {
    this.naam = naam;
  }

  //no @XmlElement here!
  public String getNaam() {
    return naam;
  }

  .....
}