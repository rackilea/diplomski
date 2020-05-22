@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MyRealConfigClass.class, MockObjectsConfig.class)
@ActiveProfiles({"test"})
public class MyJunitTest {

    @Autowired
    private RestController restController;

}