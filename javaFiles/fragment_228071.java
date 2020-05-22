Socket socket = ...; // Create and connect the socket
DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

// Send first message
dOut.writeByte(1);
dOut.writeUTF("This is the first type of message.");
dOut.flush(); // Send off the data

// Send the second message
dOut.writeByte(2);
dOut.writeUTF("This is the second type of message.");
dOut.flush(); // Send off the data

// Send the third message
dOut.writeByte(3);
dOut.writeUTF("This is the third type of message (Part 1).");
dOut.writeUTF("This is the third type of message (Part 2).");
dOut.flush(); // Send off the data

// Send the exit message
dOut.writeByte(-1);
dOut.flush();

dOut.close();