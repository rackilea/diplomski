@Configuration
@ImportResource({VcheckAppConfig.ModuleResources, TestAppConfig.MockModuleResources})
public class TestAppConfig {

    public static final String MockModuleResources = "classpath:bcpbx-api-vcheck-rest-beans-mock.xml";

    @Bean
    public Account testAccount() {
        return new Account("TEST_ACCOUNT", new Vendor("TEST_VENDOR"));
    }
}