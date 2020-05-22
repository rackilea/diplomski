public class DataProcessController { 
    private ApiClient apiClient = null; 

    private DataProcessController() { 
        regenerateClient(); 
    }

    public ApiClient getApiClient() { return apiClient; }

    // add this to regenerate the client whenever url changes
    public void regenerateClient() {
        apiClient = ServiceGenerator.createService(ApiClient.class);
    }
}