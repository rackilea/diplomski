@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/context.xml", "/test-context.xml"})
public class PersonValidatorTest {

    @Autowired
    private Validator validator;
....