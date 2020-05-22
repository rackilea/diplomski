public class SynchronizationTest {

public class Event  {

    boolean signal = false;
    synchronized String getEvent(){
        while(!signal) {
            try{
                wait();
            }
            catch(InterruptedException e) {}
        }
        return "This is an event";
    }

    synchronized public void waitNextEvent(){
        while(signal) {
            try{
                wait();
            }
            catch(InterruptedException e) {}
        }
    }

    synchronized public void setSignal(boolean signal) {
        this.signal = signal;
        this.notifyAll();
    }
}

class EventChecker extends Thread {

    private Event event;
    public EventChecker(Event event) {
       this.event=event;
    }

    public void run(){
        while (true) {
            String eventStr = event.getEvent();
            System.out.println("EventChecker: Got event '"+eventStr+"'");
            System.out.println("EventChecker: wait for new event.. \n");
            event.waitNextEvent();
        }
    }
}

class EventSignaler extends Thread {

    private Event event;
    public EventSignaler(Event event) {
       this.event=event;
    }

    public void run(){
        while (true) {
            event.setSignal(true);
            System.out.print("EventSignaler: Sending new signal\n");
            try {
                sleep((int) (Math.random()*2200));
            } catch(Exception e){}

            event.setSignal(false);
            System.out.print("EventSignaler: Deactivating signal\n\n");
            try {
                sleep((int) (Math.random()*4200));
            }
            catch(Exception e){}
       }
    }
}

public void startTest() {

    Event event=new Event();
       EventSignaler eventSignaler = new EventSignaler(event);
       EventChecker eventChecker=new EventChecker(event);
       eventSignaler.start();
       eventChecker.start();
}

public static void main(String arg[]) {

    SynchronizationTest synchro = new SynchronizationTest();
    synchro.startTest();
}
}