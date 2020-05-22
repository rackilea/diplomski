public static Map<Integer, Integer> countNumerals(final String str) {
  final Map<Integer, Integer> freq = new HashMap<Integer, Integer>(10);
  for (final char c : str.toCharArray()) {
    if (Character.isDigit(c)) {
      final int num = Character.getNumericValue(c);
      Integer occ = freq.get(num);
      if (occ == null) {
        occ = 0;
      }
      freq.put(num, occ + 1);
    }
  }
  return freq;      
}