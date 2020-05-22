public static class LocalDateDiscreteDomain extends DiscreteDomain<LocalDate> {
  @Override public LocalDate next(LocalDate value) {
    return value.plusDays(1);
  }
  @Override public LocalDate previous(LocalDate value) {
    return value.minusDays(1);
  }
  @Override public long distance(LocalDate start, LocalDate end) {
    return DAYS.between(start, end);
  }
}