Comparator<Map<String, String>> c
    = Comparator.comparing((Map<String, String> m) -> m.get(Key1))
                .thenComparing(m -> m.get(Key2))
                .thenComparing(m -> m.get(Key3))
                .thenComparing(m -> m.get(Key4));

listOfMaps.sort(c);