public JSONObject getRestRequest() { // 1 - your method is invoked by another method and control starts here
    // 2 - Initialize a Future to use to synchronously get the result
    RequestFuture<JSONObject> future = RequestFuture.newFuture();

    // 3 - You create a new request object with the future as the listener - no networking is happening yet
    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, this.restPath, future, future);

    // 4 - You return the value the future will obtain by making the network request
    // THIS IS A BLOCKING CALL SO DON'T DO THIS ON THE MAIN THREAD
    // This will also throw an exception if it fails
    return future.get();
}