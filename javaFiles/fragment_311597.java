import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RunLengthEncoding {

    public static String encode(String source) {
        StringBuffer dest = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while (i+1 < source.length() && source.charAt(i) == source.charAt(i+1)) {
                runLength++;
                i++;
            }
            /* We will swap these so they fit your format of [Letter][Count]
            dest.append(runLength);
            dest.append(source.charAt(i));
            */
            dest.append(source.charAt(i));
            dest.append(runLength);
        }
        return dest.toString();
    }

    public static void main(String[] args) {
        String example = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
        System.out.println(encode(example));
    }
}