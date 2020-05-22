@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:my-context.xml")
    public class MyTest {
    @Autowired
    private TestClass testClass;
        @Test
        public void testname() throws Exception {
           System.out.println(testClass.toString());
        }

    }

@Controller
public class TestClass {
        @Autowired
        private MyController myController;

        public String toString(){
          return myController.toString();       
        }
}