@Entity
public class MyClass{

    @Id
    @GeneratedValue(generator = “UUID”)
    @GenericGenerator(
        name = “UUID”,
        strategy = “org.hibernate.id.UUIDGenerator”,
    )
    @Column(name = “id”, updatable = false, nullable = false)
    private UUID id;

    …
}