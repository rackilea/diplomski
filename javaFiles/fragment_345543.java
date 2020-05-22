// Dummy Data
List<Map<String, String>> materialData = new ArrayList<>();
materialData.add(createMap("data1", "123", "location1"));
materialData.add(createMap("data1", "456", "location2"));
materialData.add(createMap("data1", "678", "location3"));
materialData.add(createMap("data2", "222", "location4"));
materialData.add(createMap("data2", "111", "location5"));
materialData.add(createMap("data3", "555", "location6"));

// Grouping by `name` field in DTO class
Map<String, List<Map<String, String>>> multiMap = materialData.stream().collect(Collectors.groupingBy(map -> map.get("name")));

// Printing the results
System.out.println(multiMap);