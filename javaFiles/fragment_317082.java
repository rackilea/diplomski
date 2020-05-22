Map<String, Map<String, String>> getResults(Map<String, Map<String, String>> input) 
{
    return input.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                                          e -> {
                                              Map<String,String> map = new HashMap<>(); 
                                              map.put("X",e.getValue().get("X")); 
                                              return map;
                                          }));
}