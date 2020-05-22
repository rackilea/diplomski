@Entity(name = "AClass")
@Table(name = "a_class")
public class AClass {

    private Long auid;  
    private HClass firstId;
    private List<HClass> secondIds = new ArrayList<>();
    private List<HClass> thirdIds = new ArrayList<>();

    @Id
    @Column(name = "auid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getAuid(){return auid;}
    public void setAuid(Long hid){auid = hid;}

    @ManyToOne
    public HClass getFirstId(){return firstId;}
    public void setFirstId(HClass tid){firstId = tid;}

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<HClass> getSecondIds(){return secondIds;}
    public void setSecondIds(List<HClass> tid){secondIds = tid;}

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<HClass> getThirdIds(){return thirdIds;}
    public void setThirdIds(List<HClass> i){thirdIds = i;}

}