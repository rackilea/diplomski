public void timerDelayRemoveView(float time, final ImageView v) {
    Handler handler = new Handler(); 
    handler.postDelayed(new Runnable() {           
        public void run() {                
            v.setVisibility(View.GONE);      
        }
    }, time); 
}