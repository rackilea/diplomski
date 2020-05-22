public void onUpdate(Set<Object> objects) {
    for(Object object : objects) {
        object.addUpdateListener(new MyUpdateListener(object));
    }
}

class MyUpdateListener implements UpdateListener {
    final Object myObj; // I'm intentionally using different name here
    MyUpdateListener(Object myObj) {
        this.myObj = myObj;
    }
    @Override
    public void onUpdate() {
        processStateChange(this.myObj);
    }
}