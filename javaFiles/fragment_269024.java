class RootPojo {
    private List<ClientInfo> clients = new ArrayList<>();

    @JsonAnySetter
    public void setClients(String name, List<ClientInfo> client) {
        client.forEach(e -> {
            e.setName(name);
        });
        this.clients.addAll(client);
    }

    //general getter and toString
}

class ClientInfo {
    private String name;
    private int member;
    private String group;

    @JsonIgnore
    public String getName() {
        return name;
    }

    //general getters, setters and toString
}