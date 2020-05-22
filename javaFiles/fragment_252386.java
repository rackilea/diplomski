public class SomeClass{
    private String s1;
    private String s2;

    private SomeClass(String s1, String s2) {
      Preconditions.checkArguments(s1 != null || s2 != null, "One of s1 or s2 must be non-null!");
      this.s1 = s1;
      this.s2 = s2;
    }

    public static SomeClass fromSomeString(String s1) {
      return new SomeClass(s1, null);
    }

    public static SomeClass fromAnotherString(String s2) {
      return new SomeClass(null, s2);
    }

    public static SomeClass fromStrings(String s1, String s2) {
      return new SomeClass(s1, s2);
    }
}