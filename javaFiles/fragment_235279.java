@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    {"/path/to/spring.xml"})
public class StudentDaoImplTest {
    @Autowired
    Student student;
    @Test
    public void test1() {
        System.out.println(student);
    }
}