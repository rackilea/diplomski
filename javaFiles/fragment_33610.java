StringBuilder output = new StringBuilder();
map.entrySet().stream().sorted(
        Map.Entry.<String, Integer> comparingByValue()
        .reversed()
        .thenComparing(Map.Entry.comparingByKey()))
        .forEach(entry -> {
            output.append(entry.getKey() + " - " + entry.getValue());
        });