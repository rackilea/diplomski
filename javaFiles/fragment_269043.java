public void someFunction(final String data) {
    shortOperation(data);
    new Thread(new Runnable() {
        public void run(){
            longOperation(data);
        }
    }).start();
}