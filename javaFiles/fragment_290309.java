@Override
        public void run() {
            System.out.println("Hello I'm thread " + getName());
            if (otherThread != null) {
                while (otherThread.isAlive()) {
                    try {
                        otherThread.join();
                    } catch (InterruptedException e) {
                        // ignore
                    }
                }
            }
            System.out.println("I'm finished " + getName());
        }