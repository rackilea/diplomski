final Handler h = new Handler();
final int DELAY = 1000; //milliseconds

h.postDelayed(new Runnable(){
    public void run(){
        //Increase textview number by one here
        h.postDelayed(this, DELAY);
    }
}, DELAY);