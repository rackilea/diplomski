class IsItImmutable {
  // skipping method accessors for brevity

  // OK  <= String is immutable
  private final String str;

  // NOK <= java.util.Date is mutable, even if reference is final a date can be modified
  private final Date  date;

  // NOK <= Set operations are still possible, so this set is mutable
  private final Set<String> strs;

  // NOK <= Set is immutable, set operations are not permitted, however Dates in the set are mutable
  private final Set<Date> udates = Collections.unmodifiableSet(...);

  // OK  <= Set is immutable, set operations are not permitted, String is immutable
  private final Set<String> ustrs = Collections.unmodifiableSet(...);
}