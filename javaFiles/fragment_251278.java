public class Test {
  public static void main(String[] args) {
    Test t = new Test();
    t.mistake(new String[] { "aaa", "bbb" });
    t.mistake(new String[] { "xyzzy", "aaa", "bbb" });
  }

  String cWrd = "xyzzy";

  public void mistake(String[] arr) {
    int i = 0;
    boolean found = false;
    while (i < arr.length && !found) {
      if (arr[i].equals(cWrd)) {
        found = true;
      }
      i++;
    }
    if (!found) // The program never enters this if statement
    {
      System.out.println("Wrong Category!");
    } else {
      System.out.println("Found!");
    }
  }
}