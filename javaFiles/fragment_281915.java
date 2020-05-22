if(!needsBuffering){
    exchange.getResponseSender().send(getResource(resource));
}else{
    exchange.startBlocking();
    writeToOutputStream(resource, exchange.getOutputStream());
}