ValuedWord valuedWord1 = new ValuedWord(0,0,0,0,0,0,0,0);
ValuedWord valuedWord2 = new ValuedWord(0,2,3,0,0,0,0,0);

Map<String, ValuedWord> map = new HashMap<String, ValuedWord>();
map.put("WORD1", valuedWord1);
map.put("WORD2", valuedWord2);

String mapJson = objectMapper.writeValueAsString(map);