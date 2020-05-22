@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public abstract class AbstractTestCase {

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractTestCase.class);

}