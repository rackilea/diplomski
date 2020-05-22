public class StudentAdapter implements JsonSerializer<Student> {

 @Override
 public JsonElement serialize(Student src, Type typeOfSrc,
            JsonSerializationContext context) {

        JsonObject obj = new JsonObject();
        obj.addProperty("name", src.name);
        obj.addProperty("school", src.school.id);

        return obj;
    }
}