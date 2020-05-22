Handler handler = new Handler();
   handler.postDelayed(new Runnable(){
        @Override
        public void run() {
            bAnswer2.setBackgroundColor(Color.TRANSPARENT);           
            bAnswer3.setBackgroundColor(Color.TRANSPARENT);         
            bAnswer4.setBackgroundColor(Color.TRANSPARENT);
        }
    }, 1000);