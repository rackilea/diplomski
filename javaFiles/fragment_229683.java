@Entity
public class entityA {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public entityA(){}

    @PostPersist
    public void onPersit() {
      // logic to perform after the entity has been persisted
    }

}