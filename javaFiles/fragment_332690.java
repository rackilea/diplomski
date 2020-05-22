public interface ProjectManager {
    // add some method signatures
}


@ApplicationScoped
public class DefaultProjectManager implements ProjectManager {
    // add implementations
}

public class ProjectManagerClient {

    @Inject
    private ProjectManager projectManager;

    // work with injected bean
}