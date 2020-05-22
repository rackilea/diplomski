import java.text.DecimalFormat;

public class Solution {

    public static void main(String[] args) {

        Double f = new Double("52.2815");
        DecimalFormat decfo = new DecimalFormat("#.000000");
        String k = decfo.format(f);
        System.out.println(k);
    }
}