ArrayList<Object> list = ...
List<String> result = new ArrayList<>();

list.forEach(obj -> {    // This is a big lambda
    // Ignore elements that are not of type String
    if (!(obj instanceof String)) {
        return;
    }

    // The element is String, cast it
    String objAsText = (String) obj;
    // Collect it
    result.add(objAsText);
});