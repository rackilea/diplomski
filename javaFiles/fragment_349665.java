/**
 * The entry point to Aether, i.e. the component doing all the work.
 * 
 * @component
 */
private RepositorySystem repoSystem;

/**
 * The current repository/network configuration of Maven.
 * 
 * @parameter default-value="${repositorySystemSession}"
 * @readonly
 */
private RepositorySystemSession repoSession;

/**
 * The project's remote repositories to use for the resolution of project dependencies.
 * 
 * @parameter default-value="${project.remoteProjectRepositories}"
 * @readonly
 */
private List<RemoteRepository> projectRepos;