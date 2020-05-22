@ContextConfiguration(
         locations=
                 {"classpath:META-INF/application-conext","classpath: test-context.xml"}
    )
    @RunWith(SpringJUnit4ClassRunner.class)
    public class StepWithSkipTest {

        @Autowired
        private JobLauncherTestUtils jobLauncherTestUtils;

        @Test
        public void testStepWithSkip() throws JobInterruptedException{
            JobExecution execution = jobLauncherTestUtils.launchStep("importPersonStep");

        }
    }