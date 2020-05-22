scrollView.post(
    new Runnable() {
        @Override
        public void run() {
            new CountDownTimer(1500, 20) {
                @Override
                public void onTick(long millisUntilFinished) {
                    scrollView.scrollTo(0, (int) (textViewAbove.getBottom()-millisUntilFinished));
                }

               @Override
               public void onFinish() {                 
               }
            }.start();
        }
    }
);