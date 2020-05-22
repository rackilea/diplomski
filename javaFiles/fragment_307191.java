@SuppressWarnings("InstanceMethodNamingConvention")
@ContextConfiguration(classes = {ServiceTest.class})
public class SpringAwareTest {

    @ClassRule
    public static final SpringAware SPRING_AWARE = SpringAware.forClass(SpringAwareTest.class);

    @Rule
    public TestRule springAwareMethod = SPRING_AWARE.forInstance(this);

    @Rule
    public TestName testName = new TestName();

    ...
}