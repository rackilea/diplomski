public static void convert(String args) {
        JsonParser parser = new JsonParser();
        String json = parser.parse(args)
                            .getAsJsonObject()
                            .getAsJsonObject("body")
                            .getAsJsonObject("response")
                            .toString();

        // Now do the magic.
        RecordingListResponseDTO data = new GsonBuilder()
                 .registerTypeAdapter(Date.class, new MyDateTypeAdapter())
                .create().fromJson(json, RecordingListResponseDTO.class);
        // Show it.
        System.out.println("converted data :"+data);
}