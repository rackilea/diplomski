@Entity
@Table(name = "TagAbstract")
public class TagAbstract {
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence", allocationSize = 10)
    @Column(name = "tag_abstract_ID")
    private long tagAbstractId;

    @OneToMany(mappedBy = "tagAbstract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TagConf> tagConfigs = new ArrayList<>();

    public List<TagConf> getTagConfigs() {
        return tagConfigs;
    }
}

@Entity
@Table(name = "TagConf")
public class TagConf {
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence", allocationSize = 10)
    @Column(name = "tag_conf_ID")
    private long tagConfId;

    @ManyToOne
    @JoinColumn(name = "tag_abstract_ID", foreignKey = @ForeignKey(name = "tag_abstract_ID"))
    private TagAbstract tagAbstract;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.DATE_TIME_PATTERN)
    @Column(name = "valid_until")
    private Date validUntil;

    public long getTagConfId() {
        return tagConfId;
    }

    public long getTagAbstractId() {
        return tagAbstract.getTagAbstractId();
    }

    public Date getValidUntil() {
        return validUntil;
    }
}