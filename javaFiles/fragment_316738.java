void testFilterPayments() {
    Multimap<LocalDate, BigDecimal> payments = ArrayListMultimap.create();

    payments.put(LocalDate.parse("2016-12-25"), new BigDecimal("1000"));
    payments.put(LocalDate.parse("2017-01-15"), new BigDecimal("250"));
    payments.put(LocalDate.parse("2017-01-15"), new BigDecimal("1250"));
    payments.put(LocalDate.parse("2017-01-15"), new BigDecimal("2250"));
    payments.put(LocalDate.parse("2017-01-25"), new BigDecimal("500"));
    payments.put(LocalDate.parse("2017-03-20"), new BigDecimal("500"));
    payments.put(LocalDate.parse("2017-04-15"), new BigDecimal("1000"));
    payments.put(LocalDate.parse("2017-06-15"), new BigDecimal("1000"));

    System.out.println(Multimaps.filterKeys(payments,
            between(LocalDate.parse("2017-01-01"), LocalDate.parse("2017-04-01"))));
    // Output:
    // {2017-01-25=[500], 2017-03-20=[500], 2017-01-15=[250, 1250, 2250]}

    System.out.println(Multimaps.filterKeys(payments,
            between(LocalDate.parse("2017-01-01"), LocalDate.parse("2017-01-15"))));
    // Output:
    // {2017-01-15=[250, 1250, 2250]}

    System.out.println(Multimaps.filterKeys(payments,
            between(LocalDate.parse("2016-01-01"), LocalDate.parse("2017-12-31"))));
    // Output:
    // {2017-06-15=[1000], 2017-01-25=[500], 2017-03-20=[500], 2016-12-25=[1000], 2017-01-15=[250, 1250, 2250], 2017-04-15=[1000]}

    System.out.println(Multimaps.filterKeys(payments,
            between(LocalDate.parse("2001-01-01"), LocalDate.parse("2015-12-31"))));
    // Output:
    // {}
}