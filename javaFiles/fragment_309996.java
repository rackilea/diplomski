@Entity
public class CityDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CityID")
    private int cityId;

    @Column(name = "CityName")
    private String cityName;
}