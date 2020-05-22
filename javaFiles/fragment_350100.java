@Entity
public class BaseEntity {
    public long id;
    @Id @GeneratedValue
    public long getId() {...
    ... other variables, getters, setters ...
}

@Local
public interface EntitiyManagerWithExtendedEntitiesInterface {
    public EntityManager getEntityManager;
}