public void send(OSCPriorityMessage msg) {

    synchronized(newMessages){
       newMessages.add(msg);
    }
}