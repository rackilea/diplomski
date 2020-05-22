@Entity
public class IndustryCode {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String industryName;

    @OneToMany(mappedBy="industryCode")
    private Set<CarrierCodes> industryCodes;

@Entity
public class TechCode {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String techName;

    @OneToMany(mappedBy="techCode")
    private Set<CarrierCodes> techCodes;

@Entity
public class CarrierCodes {
    @EmbeddedId
    private CarrierCodesId id = new CarrierCodesId(); 

    @ManyToOne
    @MapsId("techCodeId")
    private TechCode techCode;

    @ManyToOne
    @MapsId("industryCodeId")
    private IndustryCode industryCode;

@SuppressWarnings("serial")
@Embeddable
public class CarrierCodesId implements Serializable {
    private Long industryCodeId;
    private Long techCodeId;

@Entity
public class Register {
    @Id
    private Long mobileNumber;
    @ManyToOne
    // optional but nice to have consistent names
    @JoinColumns({
        @JoinColumn(name="industryCode_id", referencedColumnName="industryCode_id"),
        @JoinColumn(name="techCode_id", referencedColumnName="techCode_id")
        })
    private CarrierCodes carrierCodes;