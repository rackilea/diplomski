ArrayList<Object> list = ...

List<String> result = new ArrayList<>();
// Iterate all elements
for (Object obj : list) {
    // Ignore elements that are not of type String
    if (!(obj instanceof String)) {
        continue;
    }

    // The element is String, cast it
    String objAsText = (String) obj;
    // Collect it
    result.add(objAsText);
}