public class ArtifactReference {
    private MavenProject mavenProject;
    private RepositorySystem repoSystem;
    private RepositorySystemSession repoSession;
    private List<RemoteRepository> repositories;
    private List<String> specifiedDependencies;
}