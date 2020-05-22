while(true){
  //how many channel keys are available
  int available = selector.select(); 
  //select is blocking, but should only return if available is >0, this is more of a sanity check
  if(available == 0) continue;

  Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
  while(keys.hasNext()){
    SelectionKey key = keys.next();
    keys.remove();
    //someone is trying to connect to the server socket
    if(key.isAcceptable())  doAccept(key); 
    //someone is sending us data
    else if(key.isReadable()) doRead(key); 
    //we are trying to (and can) send data
    else if(key.isWritable()) doWrite(key);
}