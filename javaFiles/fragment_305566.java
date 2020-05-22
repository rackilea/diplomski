@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguratiion({testHibernate.xml, testSpring.xml , .... })
@TestExecutionListeners({...})
public class TestClass {
....
   @Test
   public void test1(){ 
     ...
   }
}