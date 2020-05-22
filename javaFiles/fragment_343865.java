@DeclareRoles({"administrator","operator","user"})
@PermitAll
@Stateless
public class myFacade {

    @PersistenceContext(unitName = "myPersistencePU")
    private EntityManager em;

    @Resource EJBContext securityContext;

    public DataStuff find(Object id) {
        //Now the securityContext is != null :-D
        String username = securityContext.getCallerPrincipal().getName();
        if(username.equals("gino"){
            return null;
        }
        return getEntityManager().find(entityClass, id);
    }
}