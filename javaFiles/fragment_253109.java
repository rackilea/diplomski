@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring-beans.xml")
public class MyIntegrationTest {

   @Autowired
   DataSource dataSource;

}