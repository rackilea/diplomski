private <T> Response<T> sendCommand(/* ... */, TypeToken<T> responseType) {
    Gson gson = new Gson();

    // preparing and sending request etc.

    String responseJson = "..."; // response JSON is valid (already verified)

    Type type = new TypeToken<Response<T>>() { }
            .where(new TypeParameter<T>() { }, responseType)
            .getType();
    Response<T> result = gson.fromJson(responseJson, type);
    return result;
}

private void doSomething() {
    Response<Device> response =
            sendCommand("getSomeDevice", new TypeToken<Device>() { });
}