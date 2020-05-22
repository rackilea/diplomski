ArrayList<Socket> clientsList = rooms.get(roomName);
if(clientsList == null) {
    clientsList = new ArrayList<Socket>();
    rooms.put(roomName, clientsList);
}
clientsList.add(socket);