@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    ...
})
public class Stories extends JUnitStories {

    @Before
    public void setUp() throws Exception {
        configuredEmbedder()
                // turn on parallel test execution
                .useExecutorService(newFixedThreadPool(30, new ThreadFactoryBuilder()
                    .setDaemon(true)
                    .build()));

        configuredEmbedder()
                .embedderControls()
                ...
                // don't use it this way not to produce multiThreading = true and delayed StoryReporter callbacks
                // and you will see your application logging 'for each jbehave step'
                // .useThreads(30);
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                ...
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        ...
                        .withFormats(HTML)
                        .withReporters(teamCityReporter));
    }
}