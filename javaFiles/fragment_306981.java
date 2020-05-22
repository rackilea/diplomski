boolean isNumber (String token) {
  try {
    Integer.parseInt(token);
    return true;
  } catch (NumberFormatException e) {
    return false;
  }
}