import java.io.File;
import java.util.Arrays;

class Test {

  public static boolean createDirectoriesWithCommonParent(
      File parent, String...subs) {

    parent.mkdirs();
    if (!parent.exists() || !parent.isDirectory()) {
      return false;
    }

    for (String sub : subs) {
      File subFile = new File(parent, sub);
      subFile.mkdir();
      if (!subFile.exists() || !subFile.isDirectory()) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
     createDirectoriesWithCommonParent(new File("test/foo"), "a", "b", "c");
  }
}