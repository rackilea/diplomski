boolean portTaken = false;
ServerSocket socket = null;
try {
    socket = new ServerSocket(portNumber);
    } 
catch (IOException e) {
    portTaken = true;
}