public static void main (String[] args) {
  args = new String[] {"godi","doge"};
  char[] first = args[0].toCharArray();
  char[] second = args[1].toCharArray();

  for (int i = 0; i < first.length; i++) {
    char c = first[i];
    char upper = Character.toUpperCase(c);
    boolean changed = false;
    for (int j = 0; j < second.length; j++) {
        if (second[j] == c) {
            second[j] = upper;
            changed = true;
        }
    }
    if (changed) {
        for (int j = 0; j < first.length; j++) {
            if (first[j] == c) {
                first[j] = upper;
            }
        }
    }
  }
  System.out.println(new String(first));
  System.out.println(new String(second));
}