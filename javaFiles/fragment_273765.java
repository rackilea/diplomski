Set<Server> servers = getServers();
    Map<String, String> serverData = new ConcurrentHashMap<>();

    servers.parallelStream().forEach((server) -> {
        serverData.put(server.getIdentifier(), server.fetchData());
    });