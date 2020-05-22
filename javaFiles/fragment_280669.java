Client client = new Client(new Context(), Protocol.HTTP);

for (int i = 0; i < 5; i++) {
    ClientResource clientResource = new ClientResource("http://...");
    clientResource.setNext(client);

    Representation representation = clientResource.get();
    (...)
}