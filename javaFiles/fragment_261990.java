final String knownValue = "TC-41";
final Iterator<String> iterable = jsonObject.keys();
while (iterable.hasNext()) {
    String key = iterable.next();
    if (jsonObject.getString(key).equals(knownValue)) {
        // key has the value you are looking for
       return;
    }
}