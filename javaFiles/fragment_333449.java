// create Map with count occurence
Map<Character, Integer> countMap = new HashMap<>();
for (Character value : input) {
    if (!countMap.containsKey(value)) {
        countMap.put(value, 1);
    } else {
        countMap.put(value, countMap.get(value) + 1);
    }
}

// filter Map
List<Character> collect = new ArrayList<>();
for (Map.Entry<Character, Integer> value : countMap.entrySet()) {
    if( value.getValue() == 1)  {
        collect.add(value.getKey());
    }
}

System.out.println(collect);