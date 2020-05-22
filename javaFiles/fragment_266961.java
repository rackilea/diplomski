HashMap<String, Integer> dicCodeToIndex;
dicCodeToIndex = new HashMap<String, Integer>();

// valuating
dicCodeToIndex.put("123", 1);
dicCodeToIndex.put("456", 2);

// retrieving
int index = dicCodeToIndex.get("123");
// index is 1