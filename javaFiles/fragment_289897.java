import java.io.IOException;
import java.lang.NumberFormatException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class t1

{
    public static void main(String s[]) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        char ch[] = s1.toCharArray();
        for (int i = 0; i < ch.length;) {
            if ((ch[i] >= 65) && (ch[i] <= 90)) {
                i++;
            } else if ((ch[i] >= 97) && (ch[i] <= 122)) {
                i++;
            } else {
                if (ch[i] >= '0' && ch[i] <= '9') {
                    for (int p = 0; p < ch[i]-'0'; p++) {
                        System.out.print(ch[i - 1]);

                    }
                }
                i++;
            }
        }
        System.out.println("");
    }
}