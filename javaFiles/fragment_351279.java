@Entity
public class MyEntity {
    @Id
    @GeneratedValue
    @Column( columnDefinition = "uuid", updatable = false )
    public UUID getId() {
        return id;
    }
}