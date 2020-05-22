Map<String, List<ClientInfo>> clientMap = new HashMap<>();
rootPojo.getClients().forEach(e -> {
    if (clientMap.containsKey(e.getName())) {
        clientMap.get(e.getName()).add(e);
    } else {
        List<ClientInfo> clients = new ArrayList<>();
        clients.add(e);
        clientMap.put(e.getName(), clients);
    }
});

String outputJsonStr = mapper.writeValueAsString(clientMap);
System.out.println(outputJsonStr);