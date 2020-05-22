@Component("httpClient")
public class HttpClientImpl implements HttpClient {
    @Override
    public String bla() {
        return null;
    }
}

@Component("httpClientMock")
public class HttpClientMock implements HttpClient {
    @Override
    public String bla() {
        return null;
    }
}

@Component
public class Wrapper {
    @Autowired
    @Qualifier("httpClient")
    HttpClient httpClient;

    @Autowired
    @Qualifier("httpClientMock")
    HttpClient httpClientMock;
}