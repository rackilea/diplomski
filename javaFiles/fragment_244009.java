@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MyPojo.class, MyClass.class })
public class MyClassTest {

    @Autowired 
    private MyClass myClass;

    @Test
    public void test() {
        // myClass...
    }
}