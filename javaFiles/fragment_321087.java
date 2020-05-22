public String getString(String name) throws JSONException {
    Object object = get(name);
    String result = JSON.toString(object);
    if (result == null) {
        throw JSON.typeMismatch(name, object, "String");
    }
    return result;
}