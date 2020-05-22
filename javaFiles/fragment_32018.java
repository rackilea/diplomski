public static MyClass convertFromJSONToMyClass(JSONObject json) {
    if (json == null) {
        return null;
    }
    MyClass result = new MyClass();
    result.username = (String) json.get("username");
    result.name = (String) json.get("name");
    return result;
}