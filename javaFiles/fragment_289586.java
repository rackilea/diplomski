private static List<HostClientMetrics> loadMetrics(String url) {

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    List<HostClientMetrics> metrics = new ArrayList<HostClientMetrics>();

    try {
        InputStream input = new URL(url).openStream();
        JsonReader reader = new JsonReader(new InputStreamReader(input, "UTF-8"));

        reader.beginObject();

        String jsonTag = null;

        while(reader.hasNext()) {
            jsonTag = reader.nextName();
            if("aggRecords".equals(jsonTag)) {
                reader.beginObject();

                while(reader.hasNext()) {
                    jsonTag = reader.nextName();
                    if("reportRecords".equals(jsonTag)) {
                        reader.beginArray();
                        while (reader.hasNext()) {
                            HostClientMetrics hostClientMetrics = gson.fromJson(reader, HostClientMetrics.class);
                            if ("ClientPool".equals(hostClientMetrics.dimensions.type) || "ConnectionPool".equals(hostClientMetrics.dimensions.type)) {
                                metrics.add(hostClientMetrics);
                            }
                        }
                        reader.endArray();
                    }
                }
                reader.endObject();
            } else if("minRecordsMap".equals(jsonTag)) {
                reader.beginObject();
                // skip
                reader.endObject();
            }
        }

        reader.endObject();

        reader.close();
        return metrics;
    } catch (Exception ex) {
        // log error
        System.out.println("ex:" + ex);
    }

    return metrics;
}