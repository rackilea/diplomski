@Entity
public class Relation {
    @Id
    public Long id;

    @OneToOne
    @JoinColumn(name = "addressHome", referencedColumnName = "id")
    public Address addressHome;

    @OneToOne
    @JoinColumn(name = "addressWork", referencedColumnName = "id")
    public Address addressWork;
}