@Entity(name = "Person")
public class Person  {

    @Id
    private Long personId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "personId")
    private PersonAddress address;

    @OneToOne
    @MapsId
    @JoinColumn(name = "personId")
    private PersonLocation location;
}