doAccept(SelectionKey key){

//create the new socket
SocketChannel socket = ((ServerSocketChannel)key.channel()).accept(); 
//make it non-blocking as well
socket.configureBlocking(false);

...
//here you would likely have some code to init your game objects / communication protocol, etc. and generate an identifier object (used below).
//and be able to find the socket created above
...

//Since it is non blocking it needs a selector as well, and we register for both read and write events
SelectionKey socketKey = socket.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
// so we can identify the events as they come in
socketKey.attach(someSocketIndentifier);
}