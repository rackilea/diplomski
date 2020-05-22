while(true){
    if (sendPacket!= null){
        socket.send(sendPacket);
    }
    Thread.sleep(10);
}