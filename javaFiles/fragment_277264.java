public CustomObject addCustomObject (CustomObject customObject) {
    Map<CustomObject, Custom> child = parentRecord.get("customObjectName");

    res = child.get(customObject);
    if (res == null) {   
        child.put(customObject, customObject);
        return customObject;
    } else {
        return res;
    }
}