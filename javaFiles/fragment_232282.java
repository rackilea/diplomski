@Entity
public class Application {
    @Id
    private Long id;
    private String appName;
    private String appCity;

    @OneToOne(fetch = FetchType.EAGER, optional = false) 
    @JoinColumn(name = "statusid", nullable = false, insertable = false, updatable = false)
    private AppStatus appStatus;

    // getters, setters, hashCode, equals...
}