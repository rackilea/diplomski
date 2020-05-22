@Service(value=RfService.class, locator=RfServiceLocator.class)
public interface TwService extends RequestContext {
  Request<String> parse(String value);
}

public class RfService {
public String parse(String value) {
  return value.replace("a", "b");
}