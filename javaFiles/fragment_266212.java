@Path("/api/v1/person")
public class PersonApi {

   @Inject
   ICommandHandler<SavePersonCommand> commandHandler;

   @POST
   public void savePerson(Person person) {
      commandHandler.handle(new SavePersonCommand(person));
   }

}