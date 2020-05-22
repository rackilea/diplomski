public static void main(String[] args) {
  Map<Character, Character> replacers = new HashMap<>();
  replacers.put('+', '-');
  replacers.put('-', '+');

  String value = "value += 5 * 3 - (2 / 4)";
  StringBuilder out = new StringBuilder();
  for (char c : value.toCharArray()) {
    out.append(replacers.getOrDefault(c, c));
  }
  System.out.println(out.toString());
}