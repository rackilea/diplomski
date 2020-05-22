@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from "classpath:/test-config.xml"
@ContextConfiguration("/test-config.xml")
public class DAOTests {
    @Autowired
    private DatabaseDAO dao;
}