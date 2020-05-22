public class Test {

    public static void main(String[] args) throws InterruptedException {
        //create the thread to demonstrate execution
        MyThread t = new MyThread();
        //add a non activity observer
        t.addObserver(new NonActivityObserver());
        //add an activity observer
        t.addObserver(new ActivityDecendent());
        //fire off the thread
        new Thread(t).start();
        //give us time to read the output
        Thread.sleep(Long.MAX_VALUE);       
    }


    public static class MyThread implements Runnable
    {
        private ArrayList<Observer> list = new ArrayList<Observer>();

        public void addObserver(Observer arg0) {
            synchronized (list) {
                list.add(arg0);
            }
        }
        @Override
        public void run()
        {
            //no loop just doing this once for example
           synchronized(list)
           {
               for(final Observer o : list) {
                   //first try to cast to an Activity
                   try {
                       Activity act = (Activity)o;
                       //if we get here, its an activity 
                       //so invoke on its UiThread
                       act.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            Event event = new Event("From the activity's runOnUiThread method");
                            o.handleEvent(event);
                        }

                       });
                   }
                   catch (Exception e) {
                       //if we got here, the class is not an activity
                       //so it should be safe to just handle the event
                       //on this thread
                       Event event = new Event("From observers handle event method");
                       o.handleEvent(event);
                   }   
               }                      
           }
         } 
     }

    //your observer interface
    public static interface Observer {
        public void handleEvent(Event e);
    }

    //Your Event class
    public static class Event {
        private String message;
        public Event(String message) {
            this.message = message;
        }
        public void talk() {
            System.out.println(message);
        }
    }

    //An observer which isnt an activity
    public static class NonActivityObserver implements Observer {

        @Override
        public void handleEvent(Event e) {
            e.talk();
        }

    }

    //An activity which implements Observer
    public static class ActivityDecendent extends Activity implements Observer {
        @Override
        public void handleEvent(Event e) {
            e.talk();
        }
    }

    //An Activity 
    public static class Activity {
        //pretend this is the Android activity executing this runnable
        //on the UI thread
        public void runOnUiThread(Runnable r) {
            new Thread(r).start();
        }
    }
}