public void makeCall() {
    Object semafor = new Object();
    synchronized (semafor) {
        try {
            CallListener listener = new CallListener() {
                @Override
                public void callTalking(AnyEvent event) {
                    // some logic

                    synchronized (semafor) {
                        semafor.notify();
                    }
                }
            };

            Call call = CallFactory.createCall();
            call.addListener(listener);
            call.connect();

            semafor.wait();
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}