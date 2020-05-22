if (key.isConnectable()) {
if (myChannel.isConnectionPending()) {
    try{
        myChannel.finishConnect();
    }
    catch(IOException e){
        System.out.println(e);
    }
    System.out.println("Status of finishCOnnect(): " + myChannel.finishConnect() );
    System.out.println("Connection was pending but now is finished connecting.");
}