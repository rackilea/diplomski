static class Invoice {
    final BigDecimal amount;
    final int months;

    Invoice(BigDecimal amount, int months) {
        this.amount = amount;
        this.months = months;
    }
}

public static void main(String[] args) {
    List<Invoice> invoices = Arrays.asList(
            new Invoice(new BigDecimal("12.50"), 3),
            new Invoice(new BigDecimal("120.50"), 12),
            new Invoice(new BigDecimal("7.25"), 3));
    BigDecimal sum = invoices.stream()
            .map(inv -> inv.amount.divide(BigDecimal.valueOf(inv.months),
                                          RoundingMode.HALF_UP))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    System.out.println("Sum: " + sum); // 16.63
}