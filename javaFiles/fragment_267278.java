public void omnom() {
    new Thread(this, "My Thread").start();
    new Thread(
            new Runnable() {
                public void run() {
                    otherRunMethod();
                }
            }
        ).start();
}