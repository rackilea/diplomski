@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes=TestConfiguration.class,
    loader=AnnotationConfigContextLoader.class
)
@Category(IntegrationTest.class)
public class TerminalBuntsPDFTest {