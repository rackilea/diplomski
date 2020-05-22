EntityManager em = EMF.get().createEntityManager();
EntityTransaction tx = em.getTransaction();
try {
   tx.begin();
   em.persist(r);
   tx.commit();
} catch (PersistenceException ex) {
Throwable t = getLastThrowable(ex);  //fetching Internal Exception
SQLException exxx = (SQLException) t;  //casting Throwable object to SQL Exception
System.out.println(exxx.getSQLState());
if(exxx.getSQLState()==23000) // Integrity constraint violation
{
 //Custom Bussiness Logic
}