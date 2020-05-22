@RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = { "my-test-context.xml",
                                        "some-other-context.xml" })
    public class SkipSampleFunctionalTests {

        @Autowired
        private SomeBean bean;

    ...
    }