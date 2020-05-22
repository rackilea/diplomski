@Configuration
public class UserModuleConfiguration {

    @Bean
    public BasePresenter<EUser> userPresenter() {
        return new BasePresenter<EUser>() {
        };
    }
}