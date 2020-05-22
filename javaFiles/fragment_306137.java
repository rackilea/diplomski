public class StudentModelDeserializer implements JsonDeserializer<Student> {

    @Override
    public Student deserialize(JsonElement paramJsonElement, Type paramType,
            JsonDeserializationContext paramJsonDeserializationContext) throws JsonParseException {

        String studentClass = null;
        if (paramJsonElement.getAsJsonObject().get("studentClass") != null) {
            studentClass = paramJsonElement.getAsJsonObject().get("studentClass").getAsString();
        }

        Student student = new Gson().fromJson(paramJsonElement.getAsJsonObject(), Student.class);

        if (studentClass != null) {
            if (studentClass.equals("1")) {
                student.setStudentClass("starter");
            }
        }

        return student;
    }

}