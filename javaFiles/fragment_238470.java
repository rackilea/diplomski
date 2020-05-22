@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "number")
    private String number;

    @JoinColumn("person_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Person person;

  //omit setter and getter
}


public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String username;

    @OneToMany(mappedBy = "person")
    private List<Phone> phones = new ArrayList<>();
   //omit getter and setter 
}