public class PersonService {

    private PersonRepository repository;

    public PersonService() {
         InitialContext ctx = new InitialContext();
         repository = ctx.lookup("java:comp/env/repositories/person");
    }
}