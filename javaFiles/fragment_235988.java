client = createClient();
client.observable.subscribe(state -> removeClient(state));



public void removeClient(Boolean state) {
        System.out.println("Server state " + state);
        if (state == false) {
            clients.remove(client);
            System.out.println("Client remowed. List size: " + clients.size());
        }
    }