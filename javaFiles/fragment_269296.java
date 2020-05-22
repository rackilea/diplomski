Map<String, BigDecimal> divisors = ...
divisors.put("Anually", BigDecimal.valueOf(12));
...
final Map<String, BigDecimal> finalDivisors = divisors;

BigDecimal sum = invoiceList.stream()
    .map(inv -> inv.amount.divideBy(finalDivisors.get(inv.frequency))
    .sum();