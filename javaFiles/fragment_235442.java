import java.math.BigDecimal;

/**
 * @author The Elite Gentleman
 *
 */
public class BigDecimalTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BigDecimal a = new BigDecimal(Float.toString(12.47f));
        BigDecimal b = new BigDecimal(Float.toString(12.44f));
        BigDecimal c = a.subtract(b);
        System.out.println(c);
    }
}