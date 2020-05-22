public class SerializerForMyClass implements JsonSerializer<MyClass> {  

    @Override
    public JsonElement serialize(MyClass obj, Type type, JsonSerializationContext jsc) {
        Gson gson = new Gson();
        JsonObject jObj = (JsonObject)gson.toJsonTree(obj);   
        if(obj.getMyProperty()==0){
            jObj.remove("myProperty");
        }
        return jObj;
    }
}