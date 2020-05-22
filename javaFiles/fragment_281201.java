@Override
public void run() {
    while (true) {
        synchronized (strings) {
            try {
                while (strings.isEmpty()) {
                    strings.wait();
                }
                strings.remove(0);
            } catch (InterruptedException ex) {
            }
        }
    }
}