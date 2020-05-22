@Entity
@Table(name = "PERSON")
public class PersonEntity {
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    private Email email;
}