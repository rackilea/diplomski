public static void main(String[] args) {
  StringBuilder alphabet = new StringBuilder();
  for (char ch = 'a'; ch <= 'z'; ch++) {
    alphabet.append(ch);
  }
  alphabet.append(alphabet.toString().toUpperCase()).append('_');
  String pass = getPassword(alphabet.toString(), 6);
  System.out.println(pass);
}