// a method for getting a HashMap which maps keys from col1 to values from col2
 public static HashMap<String, String> getColumnMap(Sheet sheet, int col1, int col2) {
   HashMap<String, String> hashMap = new HashMap<String, String>();
   for (Row row : sheet) {
    String key = getStringCellValue(row.getCell(col1));
    String value = getStringCellValue(row.getCell(col2));
    if (hashMap.containsKey(key)) {
     value = hashMap.get(key) + value;
    }
    hashMap.put(key, value);
   }
   return hashMap;
 }