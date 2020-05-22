String json;
try (Reader reader = 
         new InputStreamReader(context.getAssets().open("currencies.json"),
                               Charsets.UTF_8)) {
    json = CharStreams.toString(reader);
}