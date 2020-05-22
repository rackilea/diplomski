@ExtendWith(SpringExtension.class)
@ComponentScan
@ActiveProfiles("web")
class ComponentScanTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testInclusion() throws Exception { // This test succeeds, no exception is thrown.
        applicationContext.getBean(IncludedBean.class);
    }

    @Test
    void testExclusion() throws Exception { // This test fails, because ExcludedBean is found.
        assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(ExcludedBean.class));
    }

    @Configuration
    @Profile("web")
    static class IncludedConfig {
        @Bean
        public IncludedBean includedBean() {
            return new IncludedBean();
        }
    }

    static class IncludedBean {
    }

    @Configuration
    @Profile("!web")
    static class ExcludedConfig {
        @Bean
        public ExcludedBean excludedBean() {
            return new ExcludedBean();
        }
    }

    static class ExcludedBean {
    }
}