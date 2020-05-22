import java.math.BigDecimal;

class Test {
    public static void main(String[] args) throws Exception {
        BigDecimal x = new BigDecimal("0")
        System.out.println(x); // 0
        x = x.setScale(5);
        System.out.println(x); // 0.00000
    }
}