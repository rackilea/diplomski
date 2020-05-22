@Test
public void shouldTryEveryPossiblePhoneticAttributeSet() throws IOException {
    Assume.assumeTrue(TestEnvironment.hasBigParseSets());
    ...
}

public class TestEnvironment {
   private static final String HAS_BIG_PARSESETS = "hasBigParseSets";
   public static boolean hasBigParseSets(){
      return "true".equalsIgnoreCase(System.getProperty(HAS_BIG_PARSESETS));
   }
}