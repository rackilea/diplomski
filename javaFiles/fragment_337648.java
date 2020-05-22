public static void main(String[] args) {
  String str = "This string has FIVE uppercase characters within itself.";
  int uppercases = 0;
  for(char c : str.toCharArray()) {
    uppercases += Character.isUpperCase(c) ? 1 : 0;
  }
  System.out.println(uppercases);
}