@Entity
@Table(name = "performance")
@Data
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer performanceId;

    @ManyToMany
    @JoinTable(
        name = "hours_performance", 
        joinColumns = { @JoinColumn(name = "performance_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "hour_id") }
    )
    private List<Hours> performanceHours = new ArrayList<>();
}

@Entity
@Table(name = "hours")
@Data
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer hourId;
    ZonedDateTime time;

    @ManyToMany(mappedBy = "performanceHours")
    private List<Performance> performances;
}