@Configuration
@EnableJpaRepositories(basePackages = "com.package.repository",
        repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class)
@PropertySource("classpath:application-embeddedmysqldb.properties")
@EnableTransactionManagement
public class EmbeddedMysqlConfig {

}