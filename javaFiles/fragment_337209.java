if (entity != null) {
    // A Simple JSON Response Read
    // InputStream instream = entity.getContent();
    // String jsonText = convertStreamToString(instream);

    String jsonText = EntityUtils.toString(entity, HTTP.UTF_8);

    // ... toast code here
}