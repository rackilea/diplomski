Set<String> patterns = new HashSet<>();

patterns.add("A???????");
patterns.add("ABCD1234");
patterns.add("A??D123?");
patterns.add("?BCD123?");

String s = "A?CD12?4";

Set<String> matches = patterns.parallelStream() // the main benefit of this
                              .filter(p -> {
                                  for (int i = 0; i < s.length(); i++) {
                                      char a = s.charAt(i),
                                           b = p.charAt(i);
                                      if (a != '?' && b != '?' && a != b)
                                          return false;
                                  }
                                  return true;
                              }).collect(Collectors.toSet());