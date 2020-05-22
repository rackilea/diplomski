public static void saveGroupChatFile(File file, List<GCRoom> list) throws IOException {
    String data = new Gson().toJson(list);
    FileOutputStream fout = new FileOutputStream(file, false);
    OutputStreamWriter osw = new OutputStreamWriter(fout);
    osw.write(data);
    osw.close();
}

public static List<GCRoom> readGroupChatFile(File file) throws IOException {
    Type listType = new TypeToken<List<GCRoom>>() {
    }.getType();
    JsonReader reader = new JsonReader(new FileReader(file));

    return new Gson().fromJson(reader, listType);
}