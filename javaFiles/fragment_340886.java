public HashMap<String, String> getSheet1Data (Sheet sheet1){
    HashMap<String, String> map = new HashMap<>();
    for (Row row : sheet1){
        map.put (row.getCell(1).getValueAsString(), row.getCell(2).getValueAsString());
     }
     return map;
}