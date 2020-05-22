new AsyncTask<Void, String, String>() {
        @Override
        protected String doInBackground(Void... params) {
            final int ID_FRAME_LAYOUT = 0;
            final Fragment[] auxCurrentFragment = {getSupportFragmentManager().findFragmentById(ID_FRAME_LAYOUT)};

            while (auxCurrentFragment[0] instanceof FilterNavigationFragment) {
                YourActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        auxCurrentFragment[0] = getSupportFragmentManager().findFragmentById(ID_FRAME_LAYOUT);
                    }
                });
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "Executed";
        }
    };