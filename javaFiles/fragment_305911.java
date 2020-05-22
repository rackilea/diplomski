CompletableFuture.runAsync(() -> {
    clients.computeIfPresent(client.getName(), (name, clients1) -> {
        List<Client> currentClients = new ArrayList<>(clients1);
        currentClients.remove(client);
        return currentClients.isEmpty() ? null : currentClients;
    });
});