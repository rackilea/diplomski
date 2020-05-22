import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
//... other imports and annotations
@ExtendWith(CustomParameterResolver.class) // your custom parameter resolver, see below
class People {

//...

  @BeforeAll
  void init(Server server) // custom stub for storage of your params
  {
    utils.setHostAndPath(server.getHost(), server.getEndpoint());
    utils.setCommonSettings();
  }

  // other methods as it is
}

  static class Server {
    private String host = "http://dev-dev/";
    private String endpoint = "people";

    public String getHost() {
      return host;
    }

    public String getEndpoint() {
      return endpoint;
    }
  }

  static class CustomParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
        ExtensionContext extensionContext) throws ParameterResolutionException {
      return (parameterContext.getParameter().getType() == Server.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext,
        ExtensionContext extensionContext) throws ParameterResolutionException {
      return new Server();
    }
  }