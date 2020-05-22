public class SnippetService {

    private TestService testService;

    public Snippet getSnippet() {
        return testService.getSnippet();
    }

    public void setTestService(TestService testService) {
      this.testService = testService;
    }
}