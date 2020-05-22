JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
    if (reader.hasNext()) {
        reader.beginObject();
        String name = reader.nextName();

        if ("content".equals(name)) {
            reader.beginArray();

            parseContentJsonArray(reader, name2ContentMap);

            reader.endArray();
        }
        name = reader.nextName();
        if ("ad".equals(name)) {
            reader.beginArray();

            parsePrerollJsonArray(reader, prerollMap);

            reader.endArray();
        }
    }