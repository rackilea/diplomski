@Entity
@Table(name = "rule")
public class Rule {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
    String type;
    ...
    @OneToOne
    @JoinColumn(...)
    Language language;
}