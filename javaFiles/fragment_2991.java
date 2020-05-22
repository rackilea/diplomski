public String writeListToJson(List myList) throws IOException {
    ByteArrayOutputStream byteStream =new ByteArrayOutputStream();
    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(byteStream ,"UTF-8");
    JsonWriter writer = new JsonWriter(outputStreamWriter);
    writer.setIndent("  ");
    writer.beginArray();
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    for (Object o : myList) {
        gson.toJson(o, o.class, writer);
    }
    writer.endArray();
    writer.close();
    return byteStream.toString("UTF-8");
}