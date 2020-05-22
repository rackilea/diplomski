@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
public class User {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;

    @NotNull
    String email;

    @NotNull
    Date created = new Date();

    @ManyToMany(mappedBy="employees")
    @LazyCollection(LazyCollectionOption.FALSE)
    // List DOES NOT WORK HERE!
    Set<Company> employedByCompanies = new HashSet<>();
    // Snip
}