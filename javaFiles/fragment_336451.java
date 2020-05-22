RequestFuture<JSONObject> future = RequestFuture.newFuture();
JsonObjectRequest request = new JsonObjectRequest(URL, new JSONObject(), future, future);
requestQueue.add(request);

try {
  JSONObject response = future.get(); // this will block
} catch (InterruptedException e) {
  // exception handling
} catch (ExecutionException e) {
  // exception handling
}