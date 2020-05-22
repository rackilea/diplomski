@Entity
public class Municipality implements Serializable {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String country;
private String province;
private String name;
@OneToMany(mappedBy="address.municipality")
private List<Person> persons;

public Municipality() {
}

...