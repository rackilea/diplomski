public abstract class AbstractTaskRunner extends Thread {


CallBack callBack = null;
Object [] params = new Object[0];

public AbstractTaskRunner (Object [] params, CallBack callBack) {
    this.params = params;
    this.callBack = callBack;

}
public abstract void doTask ();
@Override
public void run() {
    doTask();
    if (callBack != null) {
        callBack.doCall(new Object[]{"DONE"});
    }
}

}