if (clients.isEmpty()) {
    throw new InvalidClientException();
}

clients.stream()
       .filter(client -> !myMay.containsKey(client))
       .findAny() // or .findFirst()
       .ifPresent(client -> {
           throw new InvalidClientException(client);
       });