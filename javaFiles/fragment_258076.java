// 1 - Start showing some UI that a request is happening
showProgressDialog();

// 2 - A new callback to handle the network response is created - no request is happening yet
Callback<JSONObject> callback = new Callback<>() {
    public void onSuccess(JSONObject response) {
        // 4 - Some time later, when the network response finishes, this called
        // Handle response
        dismissProgressDialog(); // Back on the main thread, so safe to update the UI
    }

    public void onError(VolleyError error) {
        // 5 - Or this is called if the request failed
        // Handle error
        dismissProgressDialog(); // Back on the main thread, so safe to update the UI
    }
}
// 3 - Invoke the network request which will happen in a background thread.
// Meanwhile, the main (UI) thread is not blocked and the progress dialog continues to spin
network.getRestRequest(callback)