public class TimeZoneAdapter extends TypeAdapter<TimeZone> {
  @Override
  public void write(JsonWriter out, TimeZone value) throws IOException {
    out.value(value.getID());
  }

  @Override
  public TimeZone read(JsonReader in) throws IOException {
    return TimeZone.getTimeZone(in.nextString());
  }
}