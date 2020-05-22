@SuppressWarnings("unchecked")
Map<String, Object> user = (Map<String, Object>) dataSnapshot.getValue();
String name = (String) user.get("name");
String hair = (String) user.get("hair");
long age    = (Long)   user.get("age");
...