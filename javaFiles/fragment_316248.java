Thread timer = new Thread(){
public void run(){
    try{
        sleep(5000);
        MainActivity.this.runOnUiThread(new Runnable() {
        @Override
        public void run() {                                 
             Intent openStartingPoint = new Intent(MainActivity.this, Menu.class);
             MainActivity.this.startActivity(openStartingPoint);
             MainActivity.this.finish();
           });

    }

    }   
    catch(InterruptedException e){

        e.printStackTrace();        

    }


}


    };

timer.start();

}