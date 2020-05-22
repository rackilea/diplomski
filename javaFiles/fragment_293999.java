@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"application-context.xml"})
public class TestClass{

@Autowired
CurrentDateService service;

@Test
public void test() {

    LocalDate date = LocalDate.now();
    LocalDate date2 = service.getCurrentDate();
    assertEquals(date, date2);
}
}