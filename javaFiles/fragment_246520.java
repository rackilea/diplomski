public class GitHubTest {

    //fails
    @Test
    public void testGson1() throws Exception {
        GitHubClient.Contributor contrib = new GitHubClient.Contributor() {
            {
                login = "someguy";
                contributions = 99;
            }
        };
        Gson gson = new Gson();
        String json = gson.toJson(contrib);
        System.out.println("contents of json string: " + json);
        assertNotEquals(json, "null");
    }

    //passes
    @Test
    public void testGson2() throws Exception {
        GitHubClient.Contributor contrib = new GitHubClient.Contributor();
        contrib.contributions = 99;
        contrib.login = "someguy";
        Gson gson = new Gson();
        String json = gson.toJson(contrib);
        System.out.println("contents of json string: " + json);
        assertNotEquals(json, "null");
    }
}