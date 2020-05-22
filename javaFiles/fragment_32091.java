public class DateTimeAdapter extends TypeAdapter<DateTime> {
  private static final DateTimeFormatter FORMAT = ISODateTimeFormat.dateTime();

  public DateTime read(JsonReader reader) throws IOException {
    if (reader.peek() == JsonToken.NULL) {
      reader.nextNull();
      return null;
    }
    String dateString = reader.nextString();
    if(dateString.length() == 0) return null;
    return FORMAT.parseDateTime(dateString);
  }

  public void write(JsonWriter writer, DateTime value) throws IOException {
    if (value == null) {
      writer.nullValue();
      return;
    }
    writer.value(FORMAT.print(value));
  }
}