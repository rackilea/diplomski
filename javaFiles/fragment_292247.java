import java.util.*;
import java.lang.reflect.*;

public class ScanFloat {
    public static void main(String args[]) throws Exception {
        String str = "foo 3.14E+2 xx";
        int startPos = 4;
        Scanner s = new Scanner(str.substring(4));
        s.useLocale(Locale.ENGLISH);
        System.out.println(s.nextDouble());
        System.out.println("endingPos: " + (startPos + getPos(s)));

    }
    static int getPos(Scanner s) throws Exception {
      Field f = Scanner.class.getDeclaredField("position");
      f.setAccessible(true);
      return (int) f.get(s);
    }
}