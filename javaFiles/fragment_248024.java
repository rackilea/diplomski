@MappedSuperclass
public class JpaObject {
    @Id
    @GeneratedValue
    private Long id;
    (.... created, last updated, general stuff here....)
}