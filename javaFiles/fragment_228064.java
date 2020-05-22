public void functionA(){
//fetch value from source.
//update value to text view
//update custom textview
}


Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            // Do your task here. 
            //Call functionA() here. 
            }timerHandler.postDelayed(this, 5000);
        }
    };