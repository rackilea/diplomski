interface Listener {
     public void onValue(long num);
     public void onError(Exception e);
     public void onEndOfData();
}

public void function(Listener l) {
    try {
       for(int i=0;i<10;i++) l.onValue(i);

       // read a file 
    } catch (Exception e) {
       l.onError(e);
    } finally {
       l.onEndOfData();
    }
}