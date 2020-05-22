List<List<Object>> values = ...
String[][] valArr = values.stream()
                          .map(l -> l.stream()
                                     .map(e -> e.toString())
                                     .toArray(n -> new String[n]))
                          .toArray(n -> new String[n][]);