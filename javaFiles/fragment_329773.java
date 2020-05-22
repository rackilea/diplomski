@XmlAttribute
@Id
@Basic(optional = false)
@GeneratedValue(strategy=GenerationType.IDENTITY, generator="IdOrGenerated")
@GenericGenerator(name="IdOrGenerated",
                  strategy="....UseIdOrGenerate"
)
@Column(name = "ID", nullable = false)
private Integer id;