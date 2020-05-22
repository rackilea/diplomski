// Some where in your class
Socket socket;
DataInputStream in = new DataInputStream(socket.getInputStream());

// To read the double
double doubleValue = in.readDouble();