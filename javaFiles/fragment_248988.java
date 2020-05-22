public class PersonService {

      private final PersonRepository repository;
      public PersonService(PersonRepository repository) {
          this.repository=repository;
      }
 }