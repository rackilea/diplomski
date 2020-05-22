int repeatCount = 0;
handler = new Handler();
runnable = new Runnable() {

    @Override
    public void run() {
        switchImage();
            Log.d("MSG", "repeatCount is : " + repeatCount);
            repeatCount ++;
            if(repeatCount < 5) {
                handler.postDelayed(this, 3000);
            }
    }
};

handler.postDelayed(runnable, 3000);