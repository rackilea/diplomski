public class GUIUpdater extends AbstractTaskRunner {

public GUIUpdater(Object[] params, CallBack callBack) {
    super(params, callBack);
}

@Override
public void doTask() {
    // UPDATE YOUR GUI HERE TAKING Swing UI objects from params, e.g.
    if (params.length == 1 && params[0].equals("DONE")) {
        // HUGE TASK IS COMPLETED, DO SOMETHING IF YOU NEED TO
    }
    else if (params.length == 2) { // It's a request to update GUI
        javax.swing.JTextField txt = (javax.swing.JTextField) this.params[0];
        txt.setText((String)this.params[1]);
    }
    else {
        // UNKNOWN REQUEST
    }

}

}