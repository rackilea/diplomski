InnerData obj = new InnerData(...);//fill in with data
Gson gson = new Gson();

// convert java object to JSON format,
// and returned as JSON formatted string
String json = gson.toJson(obj);