List<Socket> myClientSockets = new ArrayList<Socket>();

while(true)
{
    Socket client = serverSocket.accept()
    myClientSockets.add(client);
}