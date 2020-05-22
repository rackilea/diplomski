@RunWith(Parameterized.class)
@SpringBootTest
@ContextConfiguration(classes = MyConfig.class)
public class MyTest {
    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();