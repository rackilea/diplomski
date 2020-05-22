import java.io.*;
import java.util.*;

public class Main {
    private static final String[] EN_VALUES = new String[] { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
    private static final String[] FR_VALUES = new String[] { "un", "deux", "trois", "quatre", "cinq", "seis", "sept", "huit", "neuf", "dix" };
    private static final String[] CN_VALUES = new String[] { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) {
            int lineCount = Integer.parseInt(in.readLine());
            for (int i = 0; i < lineCount; i++) {
                String line = in.readLine();
                String[] token = line.split("\\s+");
                System.out.println(parseNum(token[0]) + parseNum(token[1]));
            }
        }
    }

    private static int parseNum(String token) {
        if (token.matches("\\d+")) {
            return Integer.parseInt(token);
        }
        for (int i = 0; i < EN_VALUES.length; i++) {
            if (token.equalsIgnoreCase(EN_VALUES[i]) || token.equalsIgnoreCase(FR_VALUES[i]) || token.equalsIgnoreCase(CN_VALUES[i])) {
                return i + 1;
            }
        }
        throw new IllegalStateException();
    }
}