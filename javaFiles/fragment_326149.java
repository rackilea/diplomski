private static final MonthDay FINANCIAL_START = MonthDay.of(4, 6);

private static LocalDate getStartOfFinancialYear(LocalDate date) {
    // Try "the same year as the date we've been given"
    LocalDate candidate = date.with(FINANCIAL_START);
    // If we haven't reached that yet, subtract a year. Otherwise, use it.
    return candidate.isAfter(date) ? candidate.minusYears(1) : candidate;
}