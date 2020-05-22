@Entity
... discriminator annotations
public class ExtEntity extends BaseEntity {
    ... additional fields here
}

@Stateless
public class EntitiyManagerWithExtendedEntitiesBean implements EntitiyManagerWithExtendedEntitiesInterface {
    @PersitenceContext
    EntityManager em;
    public EntityManager getEntityManager() {
        return em;
    }
}