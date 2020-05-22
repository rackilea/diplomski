package dan;

import java.util.Random;

public class RandText {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String s = getRandomText(100);
        System.out.println(s);

    }


    public static String getRandomText(int len) {
        StringBuilder b = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i<len;i++) {
            char c = (char)(65+r.nextInt(25));
            b.append(c);
        }
        return b.toString();
    }
}