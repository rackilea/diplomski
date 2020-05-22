public class CoreV1Api {
    private ApiClient apiClient;

    public CoreV1Api() {
        this(Configuration.getDefaultApiClient());
    }
...
}