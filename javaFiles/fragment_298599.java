List<Map<String, Integer>> list1, list2;
...
boolean matched = list2.stream()
        .anyMatch(list2Map -> list1.stream()
                .anyMatch(map -> map.get("SubTypeId").equals(list2Map.get("SubTypeId"))
                        && map.get("TypeId").equals(list2Map.get("TypeId"))));
System.out.println(matched);