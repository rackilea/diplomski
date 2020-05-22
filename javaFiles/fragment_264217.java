// creates a client socket which connects to the first successor's server.
Socket clientSocket = new Socket(host, succ1_port);

// send the output_string to the first successor.
DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
outToServer.writeUTF(output_string);

outToServer.close();    
clientSocket.close();