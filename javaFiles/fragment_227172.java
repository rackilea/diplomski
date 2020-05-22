import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Main2 {

  private static String read(File file) throws IOException {
    StringBuilder b = new StringBuilder();
    Scanner scan = new Scanner(file);
    while(scan.hasNextLine()) {
      String line = scan.nextLine();
      b.append(line).append('\n');
    }
    return b.toString();
  }

  public static void main(String[] args) throws Exception {
    String contents = read(new File("Test2.java"));

    String slComment = "//[^\r\n]*";
    String mlComment = "/\\*[\\s\\S]*?\\*/";
    String strLit = "\"(?:\\\\.|[^\\\\\"\r\n])*\"";
    String chLit = "'(?:\\\\.|[^\\\\'\r\n])+'";
    String any = "[\\s\\S]";

    Pattern p = Pattern.compile(
        String.format("(%s)|(%s)|%s|%s|%s", slComment, mlComment, strLit, chLit, any)
    );

    Matcher m = p.matcher(contents);

    while(m.find()) {
      String hit = m.group();
      if(m.group(1) != null) {
        System.out.println("SingleLine :: " + hit.replace("\n", "\\n"));
      }
      if(m.group(2) != null) {
        System.out.println("MultiLine  :: " + hit.replace("\n", "\\n"));
      }
    }
  }
}