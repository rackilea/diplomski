public static void main(String[] args) throws DeploymentException {
    RepositorySystem system = newRepositorySystem();
    RepositorySystemSession session = newSession(system);

    Artifact artifact = new DefaultArtifact("groupId", "artifactId", "classifier", "extension", "version");
    artifact = artifact.setFile(new File("/path/to/file"));

    // add authentication to connect to remove repository
    Authentication authentication = new AuthenticationBuilder().addUsername("username").addPassword("password").build();

    // creates a remote repo at the given URL to deploy to
    RemoteRepository distRepo = new RemoteRepository.Builder("id", "default", "url").setAuthentication(authentication).build();

    DeployRequest deployRequest = new DeployRequest();
    deployRequest.addArtifact(artifact);
    deployRequest.setRepository(distRepo);

    system.deploy(session, deployRequest);
}

private static RepositorySystem newRepositorySystem() {
    DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
    locator.addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class);
    locator.addService(TransporterFactory.class, FileTransporterFactory.class);
    locator.addService(TransporterFactory.class, HttpTransporterFactory.class);
    return locator.getService(RepositorySystem.class);
}

private static RepositorySystemSession newSession(RepositorySystem system) {
    DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();
    LocalRepository localRepo = new LocalRepository("target/local-repo");
    session.setLocalRepositoryManager(system.newLocalRepositoryManager(session, localRepo));
    return session;
}