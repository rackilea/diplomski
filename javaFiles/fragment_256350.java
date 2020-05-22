final Timer someTimer = new Timer ();
    someTimer.schedule (new TimerTask () {

        @Override
        public void run () {

            ConnectionCheck2 cd = new ConnectionCheck2 (MainActivity.this.getApplicationContext ());
            final Boolean isInternetPresent = cd.isConnectingToInternet ();
            runOnUiThread (new Thread (new Runnable () {
                public void run () {

                    if (isInternetPresent) {

                        Change ();
                        someTimer.cancel ();

                        return;
                    }
                    Toast.makeText (MainActivity.this.getApplicationContext (), "NOT Connected", Toast.LENGTH_SHORT).show ();

                }
            }));
        }
    }, 0, 5000);

    if (g == 1) {
        Toast.makeText (MainActivity.this.getApplicationContext (), "Internet is connected", Toast.LENGTH_SHORT).show ();

    }

}