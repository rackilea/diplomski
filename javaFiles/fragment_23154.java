@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
@ActiveProfiles(profiles = "non-async")
public class SomeServiceIntTest {

    @Inject
    private SomeService someService;

        @Test
        public void testAsyncMethod() {

            Foo testData = prepareTestData();

            someService.asyncMethod(testData);

            verifyResults();
        }

        // verifyResult() with assertions, etc.
}