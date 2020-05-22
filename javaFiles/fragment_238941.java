public void fireMessageReceived([B msg) {
    if ( listeners != null) {
        java.util.ArrayList<E extends java.lang.Object> __list = new java.util.ArrayList<MessageListener>(listeners)
        for (java.lang.Object listener : __list ) {
            listener.messageReceived(msg)
        }
    }
}