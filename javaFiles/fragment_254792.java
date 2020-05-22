public class GitHubServiceImpl implements GitHubService {
    private Rpository repo;

    /** other methods **/

    @Override
    public List<RepositoryCommit> getAllCommits(String path) {
        return commitService.getCommits(repo, null, path));
    }
}