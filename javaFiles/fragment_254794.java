public class TestGitHubService implements GitHubService {

    private Map<String, RepositoryCommit> preArrangedCommits;
    /** other methods **/

    public void setPreArrangedCommits(Map<String, RepositoryCommit> preArrangedCommits) {
        this.preArrangedCommits = preArrangedCommits;
    }

    @Override
    public List<RepositoryCommit> getAllCommits(String path) {
        return preArrangedCommits;
    }
}