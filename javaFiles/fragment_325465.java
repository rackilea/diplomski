public class SocketClass {

    private List<MyListener> listeners = new ArrayList<MyListener>();

    public void addListener(MyListener listener) {
        listeners.add(listener);
    }

    public void onRecieve(){
        /* your code*/
        for (MyListener l : listeners)
            l.doNotify("Socket has recieved something ;P");
    }

}