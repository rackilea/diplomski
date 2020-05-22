public class WaitingDialog implements Runnable {
        volatile boolean finished;
        volatile boolean dialog;
        String message;
        String button1;
        String button2;

    public WaitingThread(String message, String button1, String button2) {
        this.button1 = button1;
        this.button2 = button2;
        this.message = message;
        finished = false;
    }

    @Override
    public void run() {
        iSyncCRMActivity.displayConfirm(message, button1, button2, new ISyncCRMActivity.displayConfirmer() {
            public void onClick(boolean result) {
                if (result) dialog = true;
                else dialog = false;
                finished = true;
            }
        });
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean getDialog {
        return dialog;
    }
}