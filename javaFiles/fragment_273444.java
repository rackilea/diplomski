// ...
public class LogWriter {

    private final TextArea txtLog;

    public LogWriter(TextArea txtLog) {
        this.txtLog = txtLog;
    }

    void printMsg(final String s) {
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    printMsg(s);
                }
            });
        } else {
            txtLog.setText(txtLog.getText() + "\n" + s);
        }
    }
}