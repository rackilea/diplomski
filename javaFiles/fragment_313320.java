@Entity
public class Person {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<Language> languages;