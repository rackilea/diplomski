public class SomeDAO {

  @NotNull
  private DB db = null;

  @Inject
  public SomeDAO (@IndicatesDatabaseName String databaseName) throws Exception {
    ...
  }
}