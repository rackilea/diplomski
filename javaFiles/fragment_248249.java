private void xMethod(){
        handler.postDelayed(runnable, 5000);
        if (run >= 5) {
            handler.removeCallbacks(runnable);
            Log.e("xMethod","handler canceled");
        }
        run++;
        Log.e("xMethod","X Method runs");
    }