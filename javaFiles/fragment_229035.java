private void insertStatus(Status status) throws JSONException {
    String string = TwitterObjectFactory.getRawJSON(status);
    JSONObject json = new JSONObject(string);
    String language = json.getString("lang");
    log.info(language);
    //    XMLResource res = (XMLResource) col.createResource(id, XMLResource.RESOURCE_TYPE);
}