public class TestService extends Service {

    ArrayList<ServiceSubscriber> subscribers = new ArrayList<>();
    private TestBinder testBinder = new TestBinder();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(){
            @Override
            public void run() {
                while(true){
                    //this is where you are receiving UDP packets
                    doStuff();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return testBinder;
    }

    private void doStuff() {
        System.out.println("Service is doing stuff!");
        //loop through your subscribers and notify them of your changes
        //a loop here isn't very costly, if there aren't many subscribers
        for (ServiceSubscriber subscriber : subscribers) {
            subscriber.messageCallback("I'm doing stuff");
        }

    }

    public class TestBinder extends Binder {

        public TestService getService() {
            return TestService.this;
        }
    }

    public void subscribeToMessages(ServiceSubscriber subscriber) {
        subscribers.add(subscriber);
    }


    public void unSubscribeToMessages(ServiceSubscriber subscriber) {
        subscribers.remove(subscriber);
    }
}