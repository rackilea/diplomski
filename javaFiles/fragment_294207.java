@Configuration
@EnableCaching
public class HazelcastConfig {
    @Bean
    public Config hazelCastConfig() {
        final Config config = new Config();            
        config.setClassLoader(Thread.currentThread().getContextClassLoader());

        final UserCodeDeploymentConfig distCLConfig = config.getUserCodeDeploymentConfig();
        distCLConfig.setEnabled(true)
          .setClassCacheMode(UserCodeDeploymentConfig.ClassCacheMode.ETERNAL)
          .setProviderMode(UserCodeDeploymentConfig.ProviderMode.LOCAL_CLASSES_ONLY);

        return config;
    }

    @Bean
    public HazelcastInstance hazelcastInstance() {
        return Hazelcast.newHazelcastInstance(hazelCastConfig());
    }
}