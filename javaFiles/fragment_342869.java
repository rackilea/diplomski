/*
/**********************************************************
/* Extension points
/**********************************************************
 */

protected void beforeEndObject(T bean, JsonGenerator jgen, SerializerProvider provider) throws IOException, JSONException {
    // May be overridden
}

protected void afterStartObject(T bean, JsonGenerator jgen, SerializerProvider provider) throws IOException, JSONException {
    // May be overridden
}