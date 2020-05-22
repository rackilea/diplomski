@Override
public void run() {
    int counter = 0;
    while (true) {
        synchronized (data) {
            if (data.size() < 5) {
                data.add("writing:: " + ++counter);
            } else {
                try {
                    data.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // we are out of the synchornized block here
        // to let others use data as a monitor somewhere else
    }
}