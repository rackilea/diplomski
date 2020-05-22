@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MultipleMongoProperties.class)
@EnableMongoRepositories(basePackages = "productcatalog.repository", repositoryFactoryBeanClass = MultipleMongoRepositoryFactoryBean.class)
public class MultipleMongoConfig {
    /* ...code... */
}