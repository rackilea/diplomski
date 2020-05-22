public class Money {
    private BigDecimal amount;
    private Currency currency;

    public Money add(Money m) {
        Money res = new Money();
        if (!currency.equals(m.currency)) {
            throw new UnsupportedOperationException();
        }
        res.currency = currency;
        res.amount = m.amount.add(amount);
        return res;
    }
}

Money result = one.add(two);