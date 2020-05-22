public class SomeController {
  private final SomeDAO someDAO;

  @Inject 
  SomeController(SomeDAO someDAO) {
    this.someDAO = someDAO;
  }
}