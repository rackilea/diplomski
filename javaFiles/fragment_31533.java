public static void main(String[] args) {
  char[] first = args[0].toCharArray();
  char[] second = args[2].toCharArray();

  for (int i = 0, max = Math.min(first.length(), second.length()); i < max; i++) {
    char c = first[i];
    if (c == second[i]) {
      c = Character.toUpperCase(c);
      first[i] = c;
      second[i] = c;
    }
  }
  System.out.println(new String(first));
  System.out.println(new String(second));
}