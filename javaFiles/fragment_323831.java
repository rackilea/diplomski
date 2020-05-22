TreeMap<String, String[]> allResults = new TreeMap<>();
allResults.put("a", new String[]{"469", "470"});
allResults.put("b", new String[]{"206", "1013", "1014"});
allResults.put("c", new String[]{"2607", "2608"});

String result = allResults.entrySet().stream()
                  .map(e -> String.join(":", e.getValue()))
                  .collect(Collectors.joining(", "));

System.out.println(result);