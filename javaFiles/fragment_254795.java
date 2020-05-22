public class CommitServiceIntegrationTest {
    // @Autowired, @Bean maybe?
    private CommitService commitService;

    // @Autowired, @Bean maybe?
    private GitHubService gitHubService;

    public void testGetAll() {
        Map<String, RepositoryCommit> preArrangedCommits = new HashMap<>();
        preArrangedCommits.put("path/", new RepositoryCommit(...));
        gitHubService.setPreArrangedCommits(preArrangedCommits);
        List<RepositoryCommit> commits = commitService.getAll();
        assertEquals(commits, preArrangedCommits);
    }
}