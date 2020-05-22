@Entity
@Table(name = "PERSON")
public class PersonEntity {
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(unique = true)
    private String emailAddress;
}