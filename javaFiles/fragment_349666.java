@Component
private RepositorySystem repoSystem;

/**
 * The current repository/network configuration of Maven.
 */
@Parameter(defaultValue = "${repositorySystemSession}")
private RepositorySystemSession repoSession;

/**
 * The project's remote repositories to use for the resolution of project dependencies.
 */
@Parameter(defaultValue = "${project.remoteProjectRepositories}")
private List<RemoteRepository> projectRepos;