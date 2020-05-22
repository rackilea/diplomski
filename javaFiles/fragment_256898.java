@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SessionParam implements Serializable{

  private String sessParam;
..
..
}