@Entity
@Table(name = "vw_countries")
public class Country{

    @Id
    private Long id;

    private String name;

    private String region;
}