void test(@Nullable String s) {
  @NonNull Optional<String> os = optNullOrEmpty(s);
  if (os.isPresent()) {
    @NonNull String s1 = os.get();
    s1.length(); // No warning :-)
  }
}