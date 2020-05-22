public class BackupCrsBISDatabaseConfig {

    ...
    @Bean
    public DataSource backupDS() {
    ....

    @Bean
    public LocalContainerEntityManagerFactoryBean crsBISBackUpEntityManager() {
      ....
      em.setDataSource(backupDS());
    }
}