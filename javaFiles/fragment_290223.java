JSONObject jsonArray = ...//get json object

Iterator<?> keys = jsonArray.keys();

while( keys.hasNext() ) {
    String key = (String) keys.next();
    System.out.println("Value: " + jsonArray.get(key));
    System.out.println("Key: " + key);
}