private static final Pattern pattern = Pattern
    .compile("^(?=.*\\d)(?=.*[a-zA-Z]).{6,10}$"); // <-- note "\\d"

private static boolean validate(String password) {
  return pattern.matcher(password).matches();
}