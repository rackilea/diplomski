@Configuration
public class RequestFactory {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public <T extends BaseRequest, U extends BaseResponse> RequestWrapper<T, U> requestWrapper(
            T request) {
        RequestWrapper<T, U> requestWrapper = new RequestWrapper<>(request);
        return requestWrapper;
    }

}