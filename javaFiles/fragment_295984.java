private <T> T parseAfterPayJson(String json, Class<T> responseClass) {
    Gson gson = new Gson();

    try {
        return gson.fromJson(json, responseClass);
    } catch (JsonSyntaxException jsex) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setFailures(Lists.newArrayList(gson.fromJson(json, Failure[].class)));
        return (T) responseObject; // this part is because of inheritance
    }
}