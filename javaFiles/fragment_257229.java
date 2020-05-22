@Component("httpClientMock")
@Profile("test")
public class HttpClientMock implements HttpClient {
    @Override
    public String bla() {
        return null;
    }
}