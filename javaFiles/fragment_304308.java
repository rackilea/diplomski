public class Transaction {
    enum Type {DEPOSIT, WITHDRAWL, INTEREST};
    private Long userId;
    private Type type;
    private BigDecimal amount;
    private Date date;  // Switch to Joda-Time or its Java 8 equivalent when you can.
    // getters, setters, etc.
    public getBalanceChange() {
        if (type != WITHDRAWL) {
            return amount;
        } else {
            return amount.negate();
        }
    }
}