@Singleton
@Provides
public JsonDeserializer provideJsonDeserializer(Timestamp2Factory tsFactory) {
  return new JsonDeserializer() {
    public Timestamp2 deserialize(JsonElement json, Type typeOfT,
        JsonDeserializationContext context) throws JsonParseException {
      return tsFactory.create(json.getAsJsonPrimitive().getAsLong());
    }
  };
}

@Reusable
@Provides
public Timestamp2Factory provideTimestamp2Factory() {
  // Merge in other parameters and dependencies if needed,
  // but Timestamp2 only needs one value that create(long) supplies.
  return Timestamp2::new;
  // or, pre-Java-8:
  return new Timestamp2Factory() {
    @Override public Timestamp2 create(long time) {
      return new Timestamp2(time);
    }
  }
}