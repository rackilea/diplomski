public class SomeController {

  private final SomeDAO someDAO;

  @Inject
  SomeController(@Assisted String databaseName) {
    this.someDAO = new SomeDAO(databaseName);
  }
}