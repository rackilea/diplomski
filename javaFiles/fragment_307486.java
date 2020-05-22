@RunWith(SpringRunner.class)
@SpringBootTest(
classes = MyTestApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

  public class ATest {

  @Autowired
  private A a;

  @MockBean
  private D d;

  @Test
  public void testDoA() {

   doReturn("Ola")
      .when(d)
      .doD();

    a.doA();
   }
}