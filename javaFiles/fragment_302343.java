@RunWith(SpringRunner.class)
public class CombinedControllerIntegrationTest2 {

    @TestConfiguration
    static class ContextConfiguration {

        @Bean
        public SolrDocumentTypeMapRepository solrDocumentTypeMapRepository() {
            LOG.debug("SolrDocumentTypeMapRepository is being initialized.");
            return new SolrDocumentTypeMapRepository(...);
        }
    }

    @Autowired
    private SolrDocumentTypeMapRepository repository;

    @Test
    public void test() {
        assertNotNull(repository);
    }
}