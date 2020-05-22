@Configuration
public class MyConfig {

    @Bean
    public ReloadingStrategy reloadingStrategy() {
        strategy = new FileChangedReloadingStrategy();
        strategy.setRefreshDelay(30000);
        return strategy;
    }
}