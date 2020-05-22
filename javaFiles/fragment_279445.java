@Override
public void onMessage(String message) {
     serverResponse.add(message);
     synchronized(someObject) {
          someObject.notify();
     }
}