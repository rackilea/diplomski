public String writeJsonStream(List<MyObj> objList) throws IOException {
    ByteArrayOutputStream baos=new ByteArrayOutputStream();
    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(baos,"UTF-8");
    JsonWriter writer = new JsonWriter(outputStreamWriter);
    writer.setIndent("  ");
    writer.beginArray();
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    for (MyObj myobj : objList) {
        gson.toJson(myobj, MyObj.class, writer);
    }
    writer.endArray();
    writer.close();
    return baos.toString("UTF-8");
}