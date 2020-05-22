private static boolean isJsonValid(final String json)
        throws IOException {
    return isJsonValid(new StringReader(json));
}

private static boolean isJsonValid(final Reader reader)
        throws IOException {
    return isJsonValid(new JsonReader(reader));
}

private static boolean isJsonValid(final JsonReader jsonReader)
        throws IOException {
    try {
        JsonToken token;
        while ( (token = jsonReader.peek()) != END_DOCUMENT && token != null ) {
            skipToken(jsonReader);
        }
        return true;
    } catch ( final MalformedJsonException ignored ) {
        return false;
    }
}

// Maybe skipToken will be a part of Gson someday: https://github.com/google/gson/issues/1054
private static void skipToken(final JsonReader reader)
        throws IOException {
    final JsonToken token = reader.peek();
    switch ( token ) {
    case BEGIN_ARRAY:
        reader.beginArray();
        break;
    case END_ARRAY:
        reader.endArray();
        break;
    case BEGIN_OBJECT:
        reader.beginObject();
        break;
    case END_OBJECT:
        reader.endObject();
        break;
    case NAME:
        reader.nextName();
        break;
    case STRING:
    case NUMBER:
    case BOOLEAN:
    case NULL:
        reader.skipValue();
        break;
    case END_DOCUMENT:
    default:
        throw new AssertionError(token);
    }
}