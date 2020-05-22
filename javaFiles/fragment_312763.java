new Handler().postDelayed(new Runnable(){

    public void run() {
        pwindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
    }

}, 100L);