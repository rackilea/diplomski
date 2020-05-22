@Retention(RUNTIME)
@JsonQualifier public @interface SingleToArray {
  final class Adapter extends JsonAdapter<List<Object>> {
    final JsonAdapter<List<Object>> delegateAdapter;
    final JsonAdapter<Object> elementAdapter;

    public static final Factory FACTORY = new Factory() {
      @Nullable @Override
      public JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations,
          Moshi moshi) {
        Set<? extends Annotation> delegateAnnotations =
            Types.nextAnnotations(annotations, SingleToArray.class);
        if (delegateAnnotations == null) {
          return null;
        }
        if (Types.getRawType(type) != List.class) {
          throw new IllegalArgumentException(
              "Only lists may be annotated with @SingleToArray. Found: " + type);
        }
        Type elementType = Types.collectionElementType(type, List.class);
        JsonAdapter<List<Object>> delegateAdapter = moshi.adapter(type, delegateAnnotations);
        JsonAdapter<Object> elementAdapter = moshi.adapter(elementType);
        return new Adapter(delegateAdapter, elementAdapter);
      }
    };

    Adapter(JsonAdapter<List<Object>> delegateAdapter, JsonAdapter<Object> elementAdapter) {
      this.delegateAdapter = delegateAdapter;
      this.elementAdapter = elementAdapter;
    }

    @Nullable @Override public List<Object> fromJson(JsonReader reader) throws IOException {
      if (reader.peek() != JsonReader.Token.BEGIN_ARRAY) {
        return Collections.singletonList(elementAdapter.fromJson(reader));
      }
      return delegateAdapter.fromJson(reader);
    }

    @Override public void toJson(JsonWriter writer, @Nullable List<Object> value)
        throws IOException {
      if (value.size() == 1) {
        elementAdapter.toJson(writer, value.get(0));
      } else {
        delegateAdapter.toJson(writer, value);
      }
    }
  }
}

@Test public void singleToArray() throws Exception {
  Moshi moshi = new Moshi.Builder().add(SingleToArray.Adapter.FACTORY).build();
  JsonAdapter<List<String>> adapter =
      moshi.adapter(Types.newParameterizedType(List.class, String.class), SingleToArray.class);
  assertThat(adapter.fromJson("[\"Tom\",\"Huck\"]")).isEqualTo(Arrays.asList("Tom", "Huck"));
  assertThat(adapter.toJson(Arrays.asList("Tom", "Huck"))).isEqualTo("[\"Tom\",\"Huck\"]");
  assertThat(adapter.fromJson("\"Jim\"")).isEqualTo(Collections.singletonList("Jim"));
  assertThat(adapter.toJson(Collections.singletonList("Jim"))).isEqualTo("\"Jim\"");
  assertThat(adapter.fromJson("[]")).isEqualTo(Collections.emptyList());
  assertThat(adapter.toJson(Collections.<String>emptyList())).isEqualTo("[]");
}