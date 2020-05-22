public class CommitService {

    private GitHubService gitHubService;

    private String path;

    public List<RepositoryCommit> getAll() {
        return gitHubService.getAllCommits(path);
    }

}