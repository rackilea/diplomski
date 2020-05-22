public List<String> parse(final JSONParser parser, final String jsonText)
        throws ParseException {
    final JSONObject json = (JSONObject) parser.parse(jsonText);
    final JSONArray rows = (JSONArray) json.get("rows");

    final List<String> durations = new ArrayList<>();

    for (final Object row : rows) {
        final JSONArray elements = ((JSONArray) ((JSONObject) row).get("elements"));
        for (Object element : elements) {
            final JSONObject duration = (JSONObject) ((JSONObject) element).get("duration");
            durations.add((String) duration.get("text"));
        }
    }

    return durations;
}