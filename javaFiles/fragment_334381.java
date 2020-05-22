public void readRedis() {
    Jedis jedis = new Jedis("localhost");

    ScanResult<String> scanResult = jedis.scan("0");
    String nextCursor = scanResult.getStringCursor();
    JSONParser parser = new JSONParser();
    int counter = 0;

    while (true) {
        nextCursor = scanResult.getStringCursor();
        List<String> keys = scanResult.getResult();
        for (counter = 0; counter < keys.size(); counter++) {
            if(counter == keys.size()) {
                break;
            }               
            try {
                JSONObject json = (JSONObject) parser.parse(jedis.rpop(keys.get(counter)));
                documentoJson(json);                    
                System.out.println("Added to function 'documentoJson'");

            } catch (ParseException e) {
                System.out.println("Not a valid JSON");
            }
        }
        if (nextCursor.equals("0")) {
            break;
        }
        scanResult = jedis.scan(nextCursor);
    }
    jedis.close();
}

public JSONArray documentoJson(JSONObject json) {
    JSONObject jObject = new JSONObject();
    JSONArray jArray = new JSONArray();
    jArray.add(json);
    jObject.put("JSON Document", jArray);
    return jArray;
 }