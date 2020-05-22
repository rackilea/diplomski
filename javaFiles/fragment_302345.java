@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = 
    SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {TestApplication.class, 
    CombinedControllerIntegrationTest2.ContextConfiguration.class})
public class CombinedControllerIntegrationTest2 {

    @TestConfiguration
    static class ContextConfiguration {

        @Bean
        public SolrDocumentTypeMapRepository solrDocumentTypeMapRepository() {
            LOG.debug("SolrDocumentTypeMapRepository is being initialized.");
            return new SolrDocumentTypeMapRepository(...);
        }
    }

    ...
}