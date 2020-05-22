@Configuration
public class UserModuleConfiguration {

    @Bean("userPresenter")
    public BasePresenter<?> userPresenter() {
        return new BasePresenter<EUser>() {
        };
    }
}