//check for errors for exit
    Listener listener = (Listener)context.getBean("listener");
    listenerContainer listenerContainer =
            (ListenerContainer)context.getBean("listenerContainer");

    try {
        while(true) {
            Thread.sleep(1000); //sleep for 1 sec
            if(!listener.getListenerState().equals(ListenerState.OPEN)) {
                listener.stopContext();
                listenerContainer.stop();
                System.exit(1);
            }>             }            
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }