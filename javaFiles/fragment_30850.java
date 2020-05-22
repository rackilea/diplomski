private int getKeyForValue(String value) {
    for (Entry<Integer, String> entry : categoryMap.entrySet()) {
         if (entry.getValue().equals(value)) {
             return entry.getKey();
         }
     }
    return 0;
}