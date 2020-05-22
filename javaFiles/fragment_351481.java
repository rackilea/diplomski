@RunWith(Theories.class)
public class MyTest{

   private static enum Configs{
     C1, C2, C3;
   }

  @DataPoints
  public static Configs[] configValues = Configs.values();

  private void doConfig(Configs config){
    swich(config){...}
  }

  @Theory
  public void test1(Config config){
      doConfig(config);

      // rest of test
  }

  @Theory
  public void test2(Config config){
     doConfig(config);

      // rest of test
  }