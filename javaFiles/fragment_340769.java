Map<String, Object> innerMap = data.get("outer_key");

// Added this if statement to handle null values in the outer map.
if (innerMap == null) {
    innerMap = new HashMap<String, Object>();
    data.put("outer_key", innerMap);
}

innerMap.put("inner_key", value);
// data.put("outer_key", innerMap); <-- This is not needed, innerMap is already a value in
                                     // the outer map.