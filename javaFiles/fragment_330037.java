private static void loadJsonInDb(final String path)
        throws IOException {
    // Java 7 language features can be easily converted to Java 6 try/finally
    // Note the way how you can decorate (wrap) everything: an input stream (byte streams) to a reader (character streams, UTF-8 here) to a JSON reader (more high-level character reader)
    try ( final JsonReader jsonReader = new JsonReader(new InputStreamReader(context.getAssets().open(path), "UTF-8")) ) {
        // Ensure that we're about to open the root object
        jsonReader.beginObject();
        // And iterate each object property
        while ( jsonReader.hasNext() ) {
            // And check it's name
            final String name = jsonReader.nextName();
            // Another Java 7 language feature
            switch ( name ) {
            // Is it datas?
            case "datas":
                // The consume it's opening array token
                jsonReader.beginArray();
                // And iterate each array element
                while ( jsonReader.hasNext() ) {
                    // Read the current value as an MyEntity instance
                    final MyEntity myEntity = myEntityTypeAdapter.read(jsonReader);
                    // Now do what you want here
                }
                // "Close" the array
                jsonReader.endArray();
                break;
            default:
                // If it's something other than "datas" -- just skip the entire value -- Gson will do it efficiently (I hope, not sure)
                jsonReader.skipValue();
                break;
            }
        }
        // "Close" the object
        jsonReader.endObject();
    }
}