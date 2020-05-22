new Thread() {
        private boolean stop = false;

        @Override public void run() {
            while (!stop) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // poll the USB and dispatch changes to the views with a Handler
            }
        }

        public void doStop() {
            stop = true;
        }
    };