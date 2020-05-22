public static void main(final String[] args) throws Exception {
    DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
    RepositorySystem system = newRepositorySystem(locator);
    RepositorySystemSession session = newSession(system);

    RemoteRepository central = new RemoteRepository.Builder("central", "default", "http://repo1.maven.org/maven2/").build();

    Artifact artifact = new DefaultArtifact("groupId:artifactId:version");
    ArtifactDescriptorRequest request = new ArtifactDescriptorRequest(artifact, Arrays.asList(central), null);
    ArtifactDescriptorResult result = system.readArtifactDescriptor(session, request);

    for (Dependency dependency : result.getDependencies()) {
        System.out.println(dependency);
    }
}

private static RepositorySystem newRepositorySystem(DefaultServiceLocator locator) {
    locator.addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class);
    locator.addService(TransporterFactory.class, FileTransporterFactory.class);
    locator.addService(TransporterFactory.class, HttpTransporterFactory.class);
    return locator.getService(RepositorySystem.class);
}

private static RepositorySystemSession newSession(RepositorySystem system) {
    DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();
    LocalRepository localRepo = new LocalRepository("target/local-repo");
    session.setLocalRepositoryManager(system.newLocalRepositoryManager(session, localRepo));
    // set possible proxies and mirrors
    session.setProxySelector(new DefaultProxySelector().add(new Proxy(Proxy.TYPE_HTTP, "host", 3625), Arrays.asList("localhost", "127.0.0.1")));
    session.setMirrorSelector(new DefaultMirrorSelector().add("my-mirror", "http://mirror", "default", false, "external:*", null));
    return session;
}