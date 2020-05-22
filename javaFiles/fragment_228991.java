public class RetryableVaultTemplate extends VaultTemplate {

    private final RetryTemplate retryTemplate;

    public RetryableVaultTemplate(VaultEndpointProvider endpointProvider,
            ClientHttpRequestFactory clientHttpRequestFactory,
            SessionManager sessionManager, RetryTemplate retryTemplate) {
        super(endpointProvider, clientHttpRequestFactory, sessionManager);
        this.retryTemplate = retryTemplate;
    }

    @Override
    public VaultResponse read(final String path) {

        return retryTemplate
                .execute(new RetryCallback<VaultResponse, RuntimeException>() {
                    @Override
                    public VaultResponse doWithRetry(RetryContext context) {
                        System.out.println("doWithRetry");
                        return RetryableVaultTemplate.super.read(path);
                    }
                });
    }

    @Override
    public <T> VaultResponseSupport<T> read(final String path, final Class<T> responseType) {

        return retryTemplate
                .execute(new RetryCallback<VaultResponseSupport<T>, RuntimeException>() {
                    @Override
                    public VaultResponseSupport<T> doWithRetry(RetryContext context) {
                        return RetryableVaultTemplate.super.read(path, responseType);
                    }
                });
    }
}