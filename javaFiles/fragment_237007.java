new Thread(){
    @Override
    public void run(){
        Log.i("tag", "I am inside thread");
        dostuff();
    }
}.start();