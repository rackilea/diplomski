public class MyPropertySource extends PropertySource<RestTemplate> {
  private static final String PREFIX = "rest.";

  public MyPropertySource() {
    super(MyPropertySource.class.getSimpleName());
  }

  @Override
  public Object getProperty(@Nonnull String name) {
    String result = null;
    if (name.startsWith(PREFIX)) {
        result = getValueFromRest(name.substring(PREFIX.length()));
    }

    return result;
  }
}