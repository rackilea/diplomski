final Map<String, List<String>> prefixes = new HashMap<>();
for (final String element : list) {
   // Go through every prefix that is at least 1 in length, 
   // but shorter than the current element).
   for (int len = 1; len < element.length() - 1; ++len) {
      final String prefix = element.substring(0, len);
      List<String> hasPrefix = prefixes.get(prefix);
      if (hasPrefix == null) {
          hasPrefix = new ArrayList<>();
          prefixes.put(prefix, hasPrefix);
      }
      hasPrefix.add(element);
   }
}

for (final String element : list) {
   if (prefixes.containsKey(element)) {
      System.out.printf("The element \"%s\" is a prefix of the following elements:\n%s", element, prefixes.get(element).toString());
   }
}