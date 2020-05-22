// Dummy Data (as described in question)
List<DTO> materialData = new ArrayList<>();
materialData.add(new DTO("data1", "123", "location1"));
materialData.add(new DTO("data1", "456", "location2"));
materialData.add(new DTO("data1", "678", "location3"));
materialData.add(new DTO("data2", "222", "location4"));
materialData.add(new DTO("data2", "111", "location5"));
materialData.add(new DTO("data3", "555", "location6"));

// Grouping by `name` field in DTO class
Map<String, List<DTO>> multiMap = materialData.stream().collect(Collectors.groupingBy(DTO::getName));

// Printing the results
System.out.println(multiMap);