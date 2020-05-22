if (server.containsKey(roomnumber)) {
    @SuppressWarnings({ "rawTypes" })
    HashMap<String, DataOutputStream> clients =
            (HashMap<String, DataOutputStream>) server.get(roomnumber);
    clients.put(nick_name, output);
} else {
    HashMap<String, Object> clients = new HashMap<>();
    clients.put(nick_name, output);
    server.put(roomnumber,clients);
}