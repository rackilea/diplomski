new Thread() {
    public void run() {
        try {
            Thread.sleep(10000);
            // Now do what is needed to remove the button.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    };
}.start();