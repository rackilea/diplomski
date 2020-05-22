@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ContextConfiguration(classes = WebDriverConfig.class)
@TestExecutionListeners({
    ScreenshotTaker.class,
    DependencyInjectionTestExecutionListener.class
})
public @interface WebDriverTestConfig {}