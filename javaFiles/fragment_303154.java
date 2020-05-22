new Thread(new Runnable() {
    public void run() {
        try {
            ziskatdata();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}).start();