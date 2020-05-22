private static Session getSession(String serverUrl, String username, String password) {
    SessionFactory sessionFactory = SessionFactoryImpl.newInstance();
    Map<String, String> params = new HashMap<String, String>();
    params.put(SessionParameter.USER, username);
    params.put(SessionParameter.PASSWORD, password);
    params.put(SessionParameter.ATOMPUB_URL, serverUrl);
    params.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
    List<Repository> repos = sessionFactory.getRepositories(params);
    if (repos.isEmpty()) {
        throw new RuntimeException("Server has no repositories!");
    }
    return repos.get(0).createSession();
}