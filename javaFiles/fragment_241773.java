// String
System.out.println(jsonObject.getString("name")); // An der Decke
System.out.println(jsonObject.getString("location")); // 48.412583|10.0385
System.out.println(jsonObject.getString("type")); // Virtual
System.out.println(jsonObject.getString("status")); // Available

// Null
System.out.println(jsonObject.isNull("size")); // true
System.out.println(jsonObject.isNull("rating")); // true

// Integer
System.out.println(jsonObject.getInt("terrain")); // 1
System.out.println(jsonObject.getInt("difficulty")); // 1