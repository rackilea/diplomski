public class ModUuidGenerator implements IdGenerator {

  @Override
  public Object nextValue() {
    return 9999999l + ModUUID.newShortId();
  }

  @Override
  public String getName() {
    return "shortUid";
  }
}