public static boolean validate(String token) {
  if (token == null || token.length() < 2) return false;
  if (!Character.isUpperCase(token.charAt(0)) return false;
  for (int i = 1; i < token.length(); i++)
    if (Character.isLowerCase(token.charAt(i)) return true;
  return false;