String line = in.readLine();
LinkedList<ClientWorkers> clients = SingletonClients.getClients();
for(int = 0; i < clients.size(); i++) {
    ClientWorker c = clients.get(i);
    //The client doesn't need to get it's own data back.
    if(c == this)
        continue;

    c.writeString(line);
}