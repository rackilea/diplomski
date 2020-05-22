public class CallableSession implements Callable<Session> {

private final String url;
private final String user;
private final String password;
private final String workspace;

public CallableSession(String url, String user, String password, String workspace) {
    this.url = url;
    this.user = user;
    this.password = password;
    this.workspace = workspace;
}

@Override
public Session call() throws Exception {

    Repository repository = JcrUtils.getRepository(url);
    SimpleCredentials credentials = new SimpleCredentials(user, password.toCharArray());
    Session session = repository.login(credentials, workspace);

    return session;
}