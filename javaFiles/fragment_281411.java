public class LazyPersonEntity extends PersonEntity {

  private PersonEntity lazilyLoadedPerson;

  @Override
  public String getName() {
    if (lazilyLoadedPerson == null) {
      lazilyLoadedPerson = runQueryToLoadPerson();
    }
    return lazilyLoadedPerson.getName();
  }
}