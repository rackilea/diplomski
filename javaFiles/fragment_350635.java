@Entity
public class XParserLinks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "link_id")
    private Integer linkId;
    @OneToMany(mappedBy = "xParserLink", targetEntity = XLinksMedia.class, cascade = CascadeType.ALL)
    private List<XLinksMedia> fotos;

    private String something;

    public XParserLinks() {
        fotos = new ArrayList<XLinksMedia>();
    }

    public XParserLinks(String something) {
        this.something = something;
        fotos = new ArrayList<XLinksMedia>();
    }
    //getter and setter

    public void add(XLinksMedia media) {
        fotos.add(media);
    }
}