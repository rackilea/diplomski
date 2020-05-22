Map<String, String> n;
n = m.entrySet()
     .stream()
     .filter(e -> e.getValue() instanceof Integer)
     .collect(Collectors.toMap(e -> e.getKey(),
                               e -> String.valueOf(e.getValue())));