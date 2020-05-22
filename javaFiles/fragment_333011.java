@Override
public void run() {

    while (!isDisplayable()) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
        }
    }
    //...