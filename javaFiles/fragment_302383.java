private class RemindTask extends TimerTask {


        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                public void run() {

                    // call your method here

                   getImageFromApi();
                }
            });

        }
    }