builder.registerTypeAdapter(BigDecimal.class, new TypeAdapter<BigDecimal>() {
  @Override
  public BigDecimal read(JsonReader reader) throws IOException {
    JsonToken token = reader.peek();
    if (token == JsonToken.STRING) {
      String stringNum = reader.nextString();
      if (stringNum == null || stringNum.isEmpty()) {
        return null;
      } else {
        return new BigDecimal(stringNum);
      }
    } else if(token == JsonToken.NUMBER) {
      return new BigDecimal(reader.nextInt());
    } else {
      reader.skipValue();
      return null;
    }
  }

  @Override
  public void write(JsonWriter writer, BigDecimal num) throws IOException {
  }
});