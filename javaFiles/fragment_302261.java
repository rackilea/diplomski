public SomeDataType remove(String key) {
    E data = key //E is a generic data type
    Node removed = remove(root, key);
    if (removed != null){
        return data;
    }
    return null;