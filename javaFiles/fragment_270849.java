@Override
public void onResume() {
    super.onResume();
    handler = new Handler();
    handler.postDelayed(new Runnable(){
        public void run(){
            update(view);
            handler.postDelayed(this, delay);
        }
    }, delay);
}

@Override
public void onPause() {
    handler.removeCallbacksAndMessages(null);
    super.onPause();
}