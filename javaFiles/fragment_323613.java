public class Test {
  public static void main(String[] args) {
    test("aa", 3, new String[]{"aa","bbb"});
  }

  private static void test(String s1, Integer i1, String... s2){
    for(String s : s2){
      System.out.println(s);
    }
  }
}