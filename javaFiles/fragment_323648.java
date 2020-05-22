[INFO] --- jbehave-maven-plugin:3.9.5:run-stories-as-embeddables (embeddable-stories) @ followerdownloader-frontend ---
[INFO] Running stories as embeddables using embedder Embedder[storyMapper=StoryMapper,storyRunner=StoryRunner,embedderMonitor=MavenEmbedderMonitor,classLoader=EmbedderClassLoader[urls=[/Users/mosofsky/Developer/FollowerDownloader/followerdownloader-frontend/target/classes/, appengine-api-1.0-sdk-1.9.17.jar, servlet-api-2.5.jar, jstl-1.2.jar, jbehave-core-3.9.5.jar, hamcrest-integration-1.3.jar, commons-collections-3.2.1.jar, commons-io-2.4.jar, commons-lang-2.6.jar, plexus-utils-3.0.10.jar, freemarker-2.3.19.jar, paranamer-2.4.jar, xstream-1.4.5.jar, xmlpull-1.1.3.1.jar, xpp3_min-1.1.4c.jar],parent=ClassRealm[plugin>org.jbehave:jbehave-maven-plugin:3.9.5, parent: sun.misc.Launcher$AppClassLoader@6da21389]],embedderControls=UnmodifiableEmbedderControls[EmbedderControls[batch=false,skip=false,generateViewAfterStories=true,ignoreFailureInStories=true,ignoreFailureInView=false,verboseFailures=false,verboseFiltering=false,storyTimeoutInSecs=300,failOnStoryTimeout=false,threads=1]],embedderFailureStrategy=<null>,configuration=org.jbehave.core.configuration.MostUsefulConfiguration@2b37d486,candidateSteps=<null>,stepsFactory=<null>,metaFilters=[],systemProperties=<null>,executorService=<null>,executorServiceCreated=false,storyManager=<null>]
[INFO] Found class names: [com.netbase.jbehaveexample.MyStories]
[INFO] Using controls UnmodifiableEmbedderControls[EmbedderControls[batch=false,skip=false,generateViewAfterStories=true,ignoreFailureInStories=true,ignoreFailureInView=false,verboseFailures=false,verboseFiltering=false,storyTimeoutInSecs=300,failOnStoryTimeout=false,threads=1]]
[INFO] Running embeddable com.netbase.jbehaveexample.MyStories
[INFO] Processing system properties {}
[INFO] Using controls UnmodifiableEmbedderControls[EmbedderControls[batch=false,skip=false,generateViewAfterStories=true,ignoreFailureInStories=true,ignoreFailureInView=false,verboseFailures=false,verboseFiltering=false,storyTimeoutInSecs=300,failOnStoryTimeout=false,threads=1]]

(BeforeStories)

[INFO] Running story com/netbase/jbehaveexample/stories/my.story

(com/netbase/jbehaveexample/stories/my.story)
Scenario: A scenario with some pending steps
Given I am a pending step (PENDING)
And I am still pending step (PENDING)
When a good soul will implement me (PENDING)
Then I shall be happy (PENDING)
@Given("I am a pending step")
@Pending
public void givenIAmAPendingStep() {
  // PENDING
}

@Given("I am still pending step")
@Pending
public void givenIAmStillPendingStep() {
  // PENDING
}

@When("a good soul will implement me")
@Pending
public void whenAGoodSoulWillImplementMe() {
  // PENDING
}

@Then("I shall be happy")
@Pending
public void thenIShallBeHappy() {
  // PENDING
}




(AfterStories)

[INFO] Generating reports view to '/Users/mosofsky/Developer/FollowerDownloader/followerdownloader-frontend/target/jbehave' using formats '[stats, console, txt, html, xml]' and view properties '{navigator=ftl/jbehave-navigator.ftl, views=ftl/jbehave-views.ftl, reports=ftl/jbehave-reports-with-totals.ftl, nonDecorated=ftl/jbehave-report-non-decorated.ftl, decorated=ftl/jbehave-report-decorated.ftl, maps=ftl/jbehave-maps.ftl}'
[INFO] Reports view generated with 1 stories (of which 1 pending) containing 1 scenarios (of which 1 pending)
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ followerdownloader-frontend ---
[INFO] Installing /Users/mosofsky/Developer/FollowerDownloader/followerdownloader-frontend/target/followerdownloader-frontend-1.0.war to /Users/mosofsky/.m2/repository/com/netbase/followerdownloader/followerdownloader-frontend/1.0/followerdownloader-frontend-1.0.war
[INFO] Installing /Users/mosofsky/Developer/FollowerDownloader/followerdownloader-frontend/pom.xml to /Users/mosofsky/.m2/repository/com/netbase/followerdownloader/followerdownloader-frontend/1.0/followerdownloader-frontend-1.0.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.486 s
[INFO] Finished at: 2014-12-22T15:08:01-08:00
[INFO] Final Memory: 22M/229M
[INFO] ------------------------------------------------------------------------