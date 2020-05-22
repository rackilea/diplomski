class MyThread implements Runnable {
 Observable observable;

 public MyThread(EventHandler observer) {
  observable = new Observable();
  observable.addObserver(observer);
 }

 public void run() {
  while (!done())  {
   Object result = doStuff();
   observable.notifyObservers(result);
  }
 }
}

// might have this be singleton
class EventHandler implements Observer {
 public synchronized void update(Observable o, Object arg) {
  accomplishOtherTask();
 }
}