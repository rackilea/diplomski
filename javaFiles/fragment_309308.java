@Bean
public ActiveMQConnectionFactory activeMQConnectionFactory() {
    ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("your broker URL");
    factory.setTrustedPackages(Arrays.asList("com.my.package"));
    return factory;
}