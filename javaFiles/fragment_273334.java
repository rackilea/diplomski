JsonWriter writer = new JsonWriter(new FileWriter(outputFilename));
writer.beginArray();
writer.beginObject();

writer.name("id").value(id);
writer.name("timestamp").value(timestamp);

writer.endObject();
writer.endArray();