public void customize(Session session) throws Exception {
    DatabaseLogin login = session.getLogin();
    Connector connector = login.getConnector();

    login.setConnector(new ConnectorWrapper(connector, m_onCreationQuery));
}