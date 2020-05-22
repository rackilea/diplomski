public class WrapperClient<T extends BaseClient> extends BaseClient {
    T realClient;

    public WrapperClient(T realClient) {
        this.realClient = realClient;
    }

    public void theMethod() {
        realClient.theMethod();
        someAdditionalLogic();
   }
}