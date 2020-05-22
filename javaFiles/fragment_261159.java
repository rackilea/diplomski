import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundTest {

    public static void main(String[] args) {

        String userInput = "42.133742";
        BigDecimal startValue = new BigDecimal(userInput);

        BigDecimal multFactor = new BigDecimal("1.23");   // => increase by 23 %

        BigDecimal result = startValue.multiply(multFactor);

        System.out.println("Original result without rounding: " + result);
        System.out.println("Scale: " + result.scale());

        // Compare different rounding modes:

        final int DECIMAL_PLACES = 2;
        BigDecimal roundDown   = result.setScale(DECIMAL_PLACES, RoundingMode.DOWN);
        BigDecimal roundHalfUp = result.setScale(DECIMAL_PLACES, RoundingMode.HALF_UP);
        BigDecimal roundUp     = result.setScale(DECIMAL_PLACES, RoundingMode.UP);

        System.out.println("Round down (" + DECIMAL_PLACES + " decimal places): " + roundDown);
        System.out.println("Round half-up (" + DECIMAL_PLACES + " dec. places): " + roundHalfUp);
        System.out.println("Round up (" + DECIMAL_PLACES + " decimal places):   " + roundUp);

    }
}