public interface LoadingHandler {
    public void beforeExecute();
    public void afterExecute();
}

public class Loading implements Runnable {
    private LoadingHandler handler;

    public Loading(LoadingHandler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        // disableButtons();
        // use interface's methods instead:
        handler.beforeExecute();

        // loop and animate the progress bar
        for (int i = 0; i <= 100; i++) {
            Game.setProgBar_loading(i);

            // wait a number of milliseconds
            try {
                Thread.sleep(10);

            } catch (InterruptedException e) {}

        }

        // enableButtons();
        // use interface's method instead:
        handler.afterExecute();
    }
}