if (v.equals(endGame)) { //if "end game" button was clicked
Toast t = Toast.makeText(getApplicationContext(), "Thanks for playing",     Toast.LENGTH_LONG);
    t.show();
Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // end app;
            }
        }, 2000);   //2 seconds
}