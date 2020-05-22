public interface MyCallback {
    void okPressed(MyData data);
}

public class MyDialog extends TrayDialog {
public MyDialog(final Shell shell, final MyData mydata, MyCallback callback) {
    super(shell);
    this.shell = shell;
    this.mydata = mydata;
    this.callback = callback;
}

@Override
protected void okPressed() {
    if (!validateData()) {
        return;
    } else {
        callback.onPressed(data);
    }
    //super.okPressed();
}

MyCallback callback = new MyCallback() {

    void okPressed(MyData data) {
        // handle data
    }
}
 final MyDialog myDialog = new MyDialog(new Shell(), this.mydata, callback);
    if (myDialog.open() == Window.CANCEL) {
        return null;
    }