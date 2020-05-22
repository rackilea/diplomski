public void timerDelayRemoveDialog(long time, final Dialog d){
    Handler handler = new Handler(); 
    handler.postDelayed(new Runnable() {           
        public void run() {                
            d.dismiss();         
        }
    }, time); 
}