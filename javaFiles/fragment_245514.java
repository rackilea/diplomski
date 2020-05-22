public void aktualizujRynek(){
    final Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            myInt  = 2;
            setImage();
        }
    });

    thread1.start();
}