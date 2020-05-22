Map<String, Long> getSortedLinkedHashMappedRankingArray(String[] rankingArray) {
    return Arrays
            .stream(rankingArray)
            .map(it -> it.split("\\s+"))
            .map(arr -> new SimpleEntry<> (arr[FIRST_PART], Long.valueOf(arr[SECOND_PART])))
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
}