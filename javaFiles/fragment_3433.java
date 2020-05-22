@Entity
public class Abiturient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "abiturent")
    private List<NomerTelefonu> phones = Lists.newArrayList();

} 

@Entity
public class NomerTelefonu{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nomer_tel_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Abiturient abiturent;

}