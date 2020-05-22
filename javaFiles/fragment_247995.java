Executor executor = Executors.newSingleThreadExecutor();

private void setByteArray(final byte a, final byte b) {
    executor.execute(new Runnable() { 
        public void run() { 
            // your code here
        } 
    });
}