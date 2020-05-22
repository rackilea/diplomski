public Client getClient() {
    Client client = new Client();
    client.setClientCode(clientCode);
    client.setClientName(clientName);
    client.setEmailAddresses(new ArrayList());
    client.getEmailAddresses().add(this.getEmailAddress());
    client.setReports(new ArrayList<>());
    client.getReports().add(this.getReport());
    return client;
}