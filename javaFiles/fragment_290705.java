public static boolean isValidFirstName(String name) {
  if (name == null || name.isEmpty() || name.trim().isEmpty()) {
    return false;
  }
  return true;
}