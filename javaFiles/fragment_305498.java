List<ListenableFuture<ResponseEntity<String>>> responseFutures = new ArrayList<>();
for (Integer studentId : studentIdsList) {
    // FIXME studentId is not used
    ListenableFuture<ResponseEntity<String>> responseEntityFuture = restTemplate.exchange(url, method, requestEntity, String.class);
    responseFutures.add(responseEntityFuture);
}
// now all requests were send, so we can process the responses
List<String> listOfResponses = new ArrayList<>();
for (ListenableFuture<ResponseEntity<String>> future: responseFutures) {
    try {
        String respBody = future.get().getBody();
        listOfResponses.add(respBody);
    } catch (Exception ex) {
        throw new ApplicationException("Exception while making Rest call.", ex);
    }
}