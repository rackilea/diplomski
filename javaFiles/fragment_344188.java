public class MyLegacyClass {

  private static Strategy strategy = new JNDIStrategy();

  public static SomeLegacyClass doSomeLegacyStuff(SomeOtherLegacyClass legacyObj) {
    // legacy logic
    SomeLegacyClass result = strategy.doSomeStuff(legacyObj);
    // more legacy logic
    return result;
  }

  static void setStrategy(Strategy strategy){
    MyLegacyClass.strategy = strategy;
  }

}

interface Strategy{
  public SomeLegacyClass doSomeStuff(SomeOtherLegacyClass legacyObj);
}

class JNDIStrategy implements Strategy {
  private static final String jndiName = "java:comp/env/jdbc/LegacyDataSource";

  public SomeLegacyClass doSomeStuff(SomeOtherLegacyClass legacyObj) {
    // do stuff using jndiName
  }
}