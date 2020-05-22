public void main(String[] args){
    Client client = Client.builder()
        .id(123)
        .build();

    client = client.toBuilder()
        .name("name")
        .build();
}