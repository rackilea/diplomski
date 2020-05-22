@NonNull Optional<String> optNullOrEmpty(@Nullable String s) {
  if (s == null || s.length() == 0)
    return Optional.empty();
  else
    return Optional.of(s);
}