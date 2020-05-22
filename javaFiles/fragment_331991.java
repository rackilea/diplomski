public class DateTypeAdapter extends TypeAdapter<Date> {
  @Override
  public void write(JsonWriter out, Date value) throws IOException {
    out.value(value.getTime());
  }

  @Override
  public Date read(JsonReader in) throws IOException {
    return new Date(in.nextLong());
  }
}