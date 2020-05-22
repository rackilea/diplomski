public class JUnitTest {

    @Rule public StubRunnerRule rule = new StubRunnerRule()
            .downloadStub("com.example","beer-api-producer")
            .withPort(6543)
            .workOffline(true);

    @Test
    public void should_work() {
        String response = new RestTemplate().getForObject("http://localhost:6543/status", String.class);

        BDDAssertions.then(response).isEqualTo("ok");
    }