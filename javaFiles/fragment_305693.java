@Configuration
class MigrationConfiguration {

    @Bean
    public MethodInvokingFactoryBean liquigraph(org.liquigraph.core.configuration.Configuration liquigraphConfig) {
        MethodInvokingFactoryBean method = new MethodInvokingFactoryBean();
        method.setTargetObject(new Liquigraph());
        method.setTargetMethod("runMigrations");
        method.setArguments(new Object[] {liquigraphConfig});
        return method;
    }

    @Bean
    public org.liquigraph.core.configuration.Configuration configuration(DataSource dataSource) {
        return new ConfigurationBuilder()
            .withDataSource(dataSource)
            .withMasterChangelogLocation("changelog.xml")
            .withRunMode()
            .build();
    }
}