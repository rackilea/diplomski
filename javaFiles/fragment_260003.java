public class SomeClass {

    @Digits(fraction = 2, integer = 16)
    private BigDecimal amount;


    private void setAmount(double d) {
        amount = BigDecimal.valueOf(d);

        amount.setScale(Util.getFraction(this, "amount"));
    }


    public static void main(String[] args) {
        new SomeClass().setAmount(12.3);
    }
}