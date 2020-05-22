import java.text.*;
import java.math.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        BigDecimal value = new BigDecimal("12385748375889879879894375893475984.03");
        System.out.println(currencyFormatter.format(value));
    }
}