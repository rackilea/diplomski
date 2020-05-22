public boolean validateUserOptionsString(String text) {
  for (UserOption option : UserOption.Values() {
    if (text.equalsIgnoreCase(option.toString())) {
      return true;
    }
  }
  return false;
}