void consume() {
        synchronized (key) {
            while (isEmpty()) {
                try {
                    key.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer[--count] = 0;
            key.notify();
        }
    }