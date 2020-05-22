if (clients.isEmpty()) {
    throw new InvalidClientException();
}

Optional<String> wrongClient = 
    clients.stream()
           .filter(client -> !myMay.containsKey(client))
           .findAny();
if (wrongClient.isPresent()) {
    throw new InvalidClientException(wrongClient.get());
}