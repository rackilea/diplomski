/**
 * JBehave to TC integration.
 */
public class TeamCityReporter extends NullStoryReporter {

    private static final LookupTranslator ESCAPE_TABLE = new LookupTranslator(new String[][] {
            { "'", "|'" },
            { "\n", "|n" },
            { "\r", "|r" },
            { "\\u", "|0x" },
            { "|", "||" },
            { "[", "|[" },
            { "]", "|]" }
    });

    private ThreadLocal<Story> story = new ThreadLocal<>();
    private ThreadLocal<String> scenario = new ThreadLocal<>();

    @Override
    @SuppressWarnings("resource")
    public void beforeStory(Story story, boolean givenStory) {
        this.story.set(story);
        this.scenario.set(null);

        try {
            startThreadOutputRedirect(new FileOutputStream(new File(workDirRelative(story.getPath()))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        forceOut(format("##teamcity[testSuiteStarted name='%s']", escape(story.getPath())));
        out.println(story.getPath());

        super.beforeStory(story, givenStory);
    }

    @Override
    public void afterStory(boolean givenStory) {
        forceOut(format("##teamcity[testSuiteFinished name='%s']", escape(story.get().getPath())));
        stopThreadOutputRedirect();

        super.afterStory(givenStory);
    }

    @Override
    public void beforeScenario(String scenario) {
        this.scenario.set(scenario);

        forceOut(format("##teamcity[testStarted name='%s']", escape(scenario)));
        out.println(scenario);

        super.beforeScenario(scenario);
    }

    @Override
    public void afterScenario() {
        forceOut(format("##teamcity[testFinished name='%s']", escape(scenario.get())));

        this.scenario.set(null);
        super.afterScenario();
    }

    @Override
    public void beforeStep(String step) {
        out.println(format("\n%s\n", step));
        super.beforeStep(step);
    }

    @Override
    public void storyNotAllowed(Story story, String filter) {
        forceOut(format("##teamcity[message text='story not allowed %s' status='WARNING']", escape(story.getName())));
        out.println(format("\n(Not allowed) %s\n", story.getPath()));
        super.storyNotAllowed(story, filter);
    }

    @Override
    public void failed(String step, Throwable cause) {
        forceOut(format("##teamcity[testFailed  name='%s' message='%s' details='%s']", new String[] { escape(scenario.get()), escape(getRootCauseMessage(cause)), escape(getStackTrace(cause)) }));
        out.println(format("\n(Failed) %s\n", step));
        cause.printStackTrace();
        super.failed(step, cause);
    }

    @Override
    public void pending(String step) {
        forceOut(format("##teamcity[testFailed  name='%s' message='Step in PENDING state: %s']", escape(scenario.get()), escape(step)));
        out.println(format("\n(Pending) %s\n", step));
        super.pending(step);
    }

    @Override
    public void notPerformed(String step) {
        out.println(format("\n(Not performed) %s\n", step));
        super.notPerformed(step);
    }

    private static String escape(String string) {
        return ESCAPE_TABLE.translate(string);
    }
}