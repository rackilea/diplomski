@Entity
public class WeeklyCare {

    @Id
    @GeneratedValue
    private Long id;

    //having reference to the citizen entity from WeeklyCare
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_cpr")
    private Citizen citizen;

    @Embedded
    private WeeklyCareIdentifier weeklyCareIdentifier;

    //constructors, getters, setters
}