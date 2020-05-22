@Bean
public Session sessionBean() {
    Map<String, String> parameter = new HashMap<String, String>();
    // ...
    SessionFactory factory = SessionFactoryImpl.newInstance();
    Session session = factory.getRepositories(parameter).get(0).createSession();
    return session;
}