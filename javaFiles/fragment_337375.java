Map<String, Map<String, Integer>> result = new HashMap<>();
for (Map<String, Map<String, Integer>> firstMap : inputMap.values()) {
    for (Entry<String, Map<String, Integer>> firstEntry : firstMap.entrySet()) {
        String upperCaseKey = firstEntry.getKey();
        Map<String, Ingeter> resultEntry = result.computeIfAbsent(
            upperCaseKey,
            _k -> new HashMap<>());
        for (Entry<String, Integer> secondEntry : firstEntry.getValue().entrySet()) {

            resultEntry.merge(secondEntry.getKey(), secondEntry.getValue(), Integer::sum);

        }
    }
}