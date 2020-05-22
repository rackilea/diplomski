public void addFirstListener(MyFirstListener listener) {
    listenerList.add(MyFirstListener.class, listener);
}

public void removeFirstListener(MyFirstListener listener) {
    listenerList.remove(MyFirstListener.class, listener);  
}