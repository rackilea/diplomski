DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
    locator.addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class);
    locator.addService(TransporterFactory.class, FileTransporterFactory.class);
    locator.addService(TransporterFactory.class, HttpTransporterFactory.class);

    RepositorySystem system = locator.getService(RepositorySystem.class);

    DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();

    LocalRepository localRepo = new LocalRepository("/path/to/your/local/repo");
    session.setLocalRepositoryManager(system.newLocalRepositoryManager(session, localRepo));

    // Set the coordinates of the artifact to download
    Artifact artifact = new DefaultArtifact("<groupId>", "<artifactId>", "jar", "<version>");
    ArtifactRequest artifactRequest = new ArtifactRequest();
    artifactRequest.setArtifact(artifact);

    // Search in central repo
    artifactRequest.addRepository(new RemoteRepository.Builder("central", "default", "http://repo1.maven.org/maven2/").build());

    // Also search in your custom repo
    artifactRequest.addRepository(new RemoteRepository.Builder("your-repository", "default", "http://your.repository.url/").build());

    // Actually resolve (and download if necessary) the artifact
    ArtifactResult artifactResult = system.resolveArtifact(session, artifactRequest);

    artifact = artifactResult.getArtifact();

    // Create a classloader with the downloaded artifact.
    ClassLoader classLoader = new URLClassLoader(new URL[] { artifact.getFile().toURI().toURL() });