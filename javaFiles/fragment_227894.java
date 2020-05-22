final class InitThread implements Runnable {
LoginForm lf;

public LoginForm getLfForSystemOut() {
    while (lf == null) {
        try {
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            return null;
        }
    }
    synchronized (lf) {
        try {
            lf.wait();
            return lf;
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
    return null;
}

@Override
public void run() {
    lf = new LoginForm();
}
}