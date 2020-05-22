Runnable progressRunnable = new Runnable() {

        @Override
        public void run() {
            progDialog.cancel();
        }
    };

    Handler pdCanceller = new Handler();
    pdCanceller.postDelayed(progressRunnable, 3000);