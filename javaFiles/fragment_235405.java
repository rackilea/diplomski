// here is a good place to init the socket
DatagramSocket socket = new DatagramSocket();
while(true){
    //receive();
    receive(socket); //pass the socket if it is a local

}