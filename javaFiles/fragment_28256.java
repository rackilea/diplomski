@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/mysql-datasource-context.xml"})
public class EmployeeDAOTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void findAllTest() {
        assertTrue(employeeDao.findByName("noname").size() == 0);
    }
}