public class MyDao {       

   public Entity getMyEntity(int id) throws ObjectNotFoundException, PersistenceException {
      try {
         // code to get Entity
         // if entity not found then 
         throw new ObjectNotFoundException("Entity with id : " + id + "Not found.");
      } catch(Exception e) { // you can catch the generic exception like HibernateException for hibernate
         throw new PersistenceException("error message", e);
      }
   }

}