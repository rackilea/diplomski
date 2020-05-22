// Receive JSON from server and parse it.
String jsonString = service.path("rest").path("hello")
    .accept(MediaType.APPLICATION_JSON).get(String.class);
JSONObject obj = new JSONObject(jsonString);

// Retrieve number array from JSON object.
JSONArray array = obj.optJSONArray("numbers");

// Deal with the case of a non-array value.
if (array == null) { /*...*/ }

// Create an int array to accomodate the numbers.
int[] numbers = new int[array.length()];

// Extract numbers from JSON array.
for (int i = 0; i < array.length(); ++i) {
    numbers[i] = array.optInt(i);
}