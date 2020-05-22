public class TestMain {
    public static void main(String[] args) throws Exception {
        JSONArray jsonArray = new JSONArray("Your JSON String");
        readJSONArray(jsonArray);
    }
    public static JSONObject readJSONObject(JSONObject inputObject) throws Exception {
        JSONObject resultObject = new JSONObject();
        Iterator iterator = inputObject.keys();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (inputObject.get(key) instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) inputObject.get(key);
                resultObject.put(getModifiedKey(key), readJSONObject(jsonObject));
            } else if (inputObject.get(key) instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) inputObject.get(key);
                resultObject.put(getModifiedKey(key), readJSONArray(jsonArray));
            } else {
                System.out.println("key= "+key+", value= "+inputObject.get(key)); //instead printing u can write your own logic
            }
        }
        return resultObject;
    }
    public static JSONArray readJSONArray(JSONArray inputArray) throws Exception {
        JSONArray resultArray = new JSONArray();
        for (int i = 0; i < inputArray.length(); i++) {
            if (inputArray.get(i) instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) inputArray.get(i);
                resultArray.put(i, readJSONObject(jsonObject));
            } else if (inputArray.get(i) instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) inputArray.get(i);
                resultArray.put(i, readJSONArray(jsonArray));
            } else {
                System.out.println("index= "+i+", value= "+inputArray.get(i)); //instead printing u can write your own logic
            }
        }
        return resultArray;
    }
}