Map<String, JSONObject> map = new HashMap<>();
for(int i = 0 ; i < 10 ; i++) {
    map.put("tempName" + i, new JSONObject());
}

JSONObject o = map.get("tempName3"); // get the 4th created (hashmaps don't have an ordering though)