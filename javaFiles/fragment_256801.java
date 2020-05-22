public void someMethodIdentifier(){ // doesn't have to be void return type, you know better than me what type you want to return.
    String jsonString = loadJSONFromAsset();
    try {
       JSONObject json = new JSONObject(jsonString);
       JSONObject jObject = json.getJSONObject("female");
       JSONObject jObject2 = jObject.getJSONObject("adult");
       String name = jObject2.toString();
    }
    catch (Exception e) {
       e.printStackTrace();
    }
}