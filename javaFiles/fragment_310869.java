import play.Configuration;

public class SomeServiceImpl implements SomeService {

  private final Configuration config;

  @Inject
  public SomeServiceImpl(Configuration config) {
     this.config = config;
     String key = config.getString("key");
  }

  @Override
  public ServiceCall<Request, Response> send() {
    String key = config.getString("key");
  }
}