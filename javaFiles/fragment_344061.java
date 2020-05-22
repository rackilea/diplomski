private String getJsonString(Student student) {
    // Before converting to GSON check value of id
    Gson gson = null;
    if (student.id == 0) {
        gson = new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create();
    } else {
        gson = new Gson();
    }
    return gson.toJson(student);
}