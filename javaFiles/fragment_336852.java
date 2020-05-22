@Entity
@Table(name = "persons")
public class Person {

    @Id
    @Column(name = "f_guid")
    private String guid;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Contact> contacts;

}

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @Column(name = "f_guid")
    private String guid;

    @Column(name = "f_info")
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)    
    @JoinColumn(name = "fk_person")
    private Person person;

}