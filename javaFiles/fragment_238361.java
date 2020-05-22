// Parse the JSON string into an array:
JSONArray array = new JSONArray("[{\"value\":01,\"label\":\"One\"},{\"value\":5,\"label\":\"Five\"}]");
// Get the length or our array (in this case, the length will be equal to 2):
int len = array.length();
// Create the two arrays to store our results
int[] values = new int[len];
String[] labels = new String[len];
// Loop through the array retrieving every object and in turn saving the values to our result arrays:
for (int index = 0; index < len; index++) {
    JSONObject curr = array.getJSONObject(i);
    values[index] = curr.getInt("value");
    labels[index] = curr.getString("label");
}