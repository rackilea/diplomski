JSONObject jsonObj = new JSONObject(line);
JSONArray asks = jsonObj.getJSONArray("asks").getJSONArray(0);
Double ask = 0.0;
for (Object o : asks) {
    if (o instanceof String){
        ask = Double.valueOf((String)o);
    } else {
        ask = (Double)o;
    }
    //do something with ask
}