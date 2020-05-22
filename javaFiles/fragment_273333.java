JsonReader reader = new JsonReader(new FileReader(inputFilename));
reader.beginArray();
reader.beginObject();

long id = -1;

while (reader.hasNext()) {
String value = reader.nextName();
if (value.equals("id")) {
  id = reader.nextLong();
} else {
  reader.skipValue();
}

reader.endObject();
reader.endArray();