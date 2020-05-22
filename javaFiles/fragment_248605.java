@Configuration
public class CustomQuerydslHandlerMethodArgumentResolverConfig implements ApplicationContextAware {

    /**
     * This class is originally the class that instantiated QuerydslAwareRootResourceInformationHandlerMethodArgumentResolver and placed it into the Spring Application Context
     * as a {@link RootResourceInformationHandlerMethodArgumentResolver} by the name of 'repoRequestArgumentResolver'.<br/>
     * By injecting this bean, we can let {@link #meetupApiRepoRequestArgumentResolver} delegate as much as possible to the original code in that bean.
     */
    private final RepositoryRestMvcConfiguration repositoryRestMvcConfiguration;

    @Autowired
    public CustomQuerydslHandlerMethodArgumentResolverConfig(RepositoryRestMvcConfiguration repositoryRestMvcConfiguration) {
        this.repositoryRestMvcConfiguration = repositoryRestMvcConfiguration;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ((GenericApplicationContext) applicationContext).getBeanFactory();
        beanFactory.destroySingleton(REPO_REQUEST_ARGUMENT_RESOLVER_BEAN_NAME);
        beanFactory.registerSingleton(REPO_REQUEST_ARGUMENT_RESOLVER_BEAN_NAME,
                                      meetupApiRepoRequestArgumentResolver(applicationContext, repositoryRestMvcConfiguration));
    }

    /**
     * This code is mostly copied from {@link RepositoryRestMvcConfiguration#repoRequestArgumentResolver()}, except the if clause checking if the QueryDsl library is
     * present has been removed, since we're counting on it anyway.<br/>
     * That means that if that code changes in the future, we're going to need to alter this code... :/
     */
    @Bean
    public RootResourceInformationHandlerMethodArgumentResolver meetupApiRepoRequestArgumentResolver(ApplicationContext applicationContext,
                                                                                                     RepositoryRestMvcConfiguration repositoryRestMvcConfiguration) {
        QuerydslBindingsFactory factory = applicationContext.getBean(QuerydslBindingsFactory.class);
        QuerydslPredicateBuilder predicateBuilder = new QuerydslPredicateBuilder(repositoryRestMvcConfiguration.defaultConversionService(),
                                                                                 factory.getEntityPathResolver());

        return new CustomQuerydslHandlerMethodArgumentResolver(repositoryRestMvcConfiguration.repositories(),
                                                               repositoryRestMvcConfiguration.repositoryInvokerFactory(repositoryRestMvcConfiguration.defaultConversionService()),
                                                               repositoryRestMvcConfiguration.resourceMetadataHandlerMethodArgumentResolver(),
                                                               predicateBuilder, factory);
    }
}