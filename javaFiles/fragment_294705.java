Handler handler = new Handler();

Runnable runnable = new Runnable(){
    public void run(){
        new Client(hostname, port,tvCount).execute(); 
        //do something
        handler.postDelayed(this, 5000);
    }
};
runnable.run();