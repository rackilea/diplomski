@RunWith(MockitoJUnitRunner.class)
public class ATest {

  @Mock
  SomeObject someObjectMock;

  A a;

 @Before
 public void setUp() {
    this.a = new MyTest();
 }

 private class MyTest extends ATest{

     @Override
     public makeNewObject(SomeImpClass1 someImpObject1, SomeImpClass2 someImpObject2){
   return someObjectMock;
 }

}