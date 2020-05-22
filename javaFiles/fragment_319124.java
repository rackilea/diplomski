@EJB
public void setService(SLSBService service){
     service.doSmg();
}

@Stateless    
public class SLSBService{
    @PersistenceContext
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void doSmg() {
        Member member = new Member();
        member.setEmail("bla@bla.de");
        member.setName("fubu");
        member.setPhoneNumber("453454534535");
        em.persist(member);
    }
}