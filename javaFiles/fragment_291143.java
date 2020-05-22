// Assume the following somewhere in your class
Socket socket;
DataOutputStream out = new DataOutputStream(socket.getOutputStream());

// Send a double
out.writeDouble(doubleValue);