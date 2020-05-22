@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@TransactionManagement(TransactionManagementType.CONTAINER) 
public void insertUser(User user)
     {
      ChangeEvent event = new ChangeEvent("user created");
      em.persist(u);
      em.persist(event);
     }