@MessagingGateway
public interface CrudGateway {

   @Gateway(requestChannel = "getChannel")
   Object get(Object id);

   @Gateway(requestChannel = "saveChannel")
   Object save(Object object);

   @Gateway(requestChannel = "deleteChannel")
   boolean delete(Object object);

}

...

@Service
public class CrudService {

   @ServiceActivator(inputChannel = "getChannel")
   public Object get(Object id) {
       // SELECT
   }

   @ServiceActivator(inputChannel = "saveChannel")
   public Object save(Object object) {
       // INSERT or UPDATE
   }

   @ServiceActivator(inputChannel = "deleteChannel")
   public boolean delete(Object object) {
       // DELETE
   }

}