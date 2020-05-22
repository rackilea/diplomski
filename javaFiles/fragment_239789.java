import java.math.*;

public class Test {
    public static void main(String[] args) {
        String input = "0.4595";
        int places = 3;
        BigDecimal dec = new BigDecimal(input)
            .setScale(places, BigDecimal.ROUND_HALF_EVEN);
        System.out.println(dec); // Prints 0.460
    }
}