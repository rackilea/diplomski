private <T> Response<T> sendCommand(/* ... */, TypeToken<Response<T>> type) {
    Gson gson = new Gson();

    // preparing and sending request etc.

    String responseJson = "..."; // response JSON is valid (already verified)

    Response<T> result = gson.fromJson(responseJson, type.getType());
    return result;
}

private void doSomething() {
    TypeToken<Response<T>> type = new TypeToken<Response<Device>>() { };
    Response<Device> response = sendCommand("getSomeDevice", type);
}