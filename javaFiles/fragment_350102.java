@Stateless
public class getSomeEntity {
    @EJB
    EntitiyManagerWithExtendedEntitiesInterface ext;
    EntityManager em;
    @PostConstruct
    public void injectEntityManager() {
        em = ext.getEntityManager();
    }
    public void ejbInterfaceMethod() {
        ... method that uses em variable (EntityManager)
    }
}