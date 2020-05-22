Function<Set<String>, Map<Character, String>> setToMap = aSet -> {
    Map<Character, String> map = new HashMap<>();
    for (String s : aSet ) {
        map.put(s.toUpperCase().charAt(0), s);
    }
    return map;
};
// or using Streams :
Function<Set<String>, Map<Character, String>> setToMap = aSet  -> 
      aSet.stream().collect(Collectors.toMap(s -> s.toUpperCase().charAt(0), 
                                             Function.identity(),
                                             (oldK, newK) -> oldK)); // merging function in cas of duplicate key