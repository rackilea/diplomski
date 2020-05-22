private Model.InnerClass innerClass;
public ControllerThread(Model.InnerClass innerClass) {
    this.innerClass = innerClass;
}
...
public void run() {
    synchronized (innerClass) {
        while (!innerClass.hasFinishedEntries()){
            innerClass.wait();
        }
    }
}