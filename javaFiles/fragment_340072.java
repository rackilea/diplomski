@Provider
public class GensonProvider implements ContextResolver<Genson> {
   private final Genson genson = new GensonBuilder().useDateFormat(yourDateFormat).create();

  @Override
  public Genson getContext(Class<?> type) {
    return genson;
  }
}