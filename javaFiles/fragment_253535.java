@Entity
@Table(name = "People")
public class Peeps implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "Decimal(10,0)")
    private String id;

    @Column(name = "PERSON_NAME")
    private String name;

}