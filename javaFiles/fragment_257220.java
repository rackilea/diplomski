@Entity
@EitherOr
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    @ManyToOne
    private Province province;

    @ManyToOne
    private Country country;

    ...
}