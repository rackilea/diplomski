List<String> actualList = new ArrayList<>();
while(result.next()){
    actualList.add(result.getString("TransText"));
}
List<String> expectedList = Arrays.asList("TXT File", 
                                          "Multiple Languages", 
                                          "Resource A", 
                                          "Resource B");
assertEquals(expectedList, actualList);