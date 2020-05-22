Thread t = new Thread() {
        public void run() {
            for (int i = 0; i < 10; i++) {
                doSomethingExpensive(time);
                final int finalI = i;
                mHandler.post(new Runnable() {
                    public void run() {
                        updateResultsInUi(finalI);
                    }
                });
            }
        }
    };
    t.start();