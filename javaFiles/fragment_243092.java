import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KGram {

    public final String str;
    public final int start;
    public final int end;

    public KGram(String str, int start, int end) {
        this.str = str;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "KGram[\"" + str + "\":" + start + "," + end + "]";
    }

    public static List<KGram> extractFrom(String input, int size) {
        char[] chars = new char[input.length()];
        int[] indexes = new int[input.length()];
        int len = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isLetter(c)) continue;

            chars[len] = c;
            indexes[len] = i;
            len++;
        }

        List<KGram> kgrams = new ArrayList<>();
        for (int i = 0, j = size - 1; j < len; i++, j++) {
            String str = new String(Arrays.copyOfRange(chars, i, j + 1));
            kgrams.add(new KGram(str, indexes[i], indexes[j]));
        }
        return kgrams;
    }
}