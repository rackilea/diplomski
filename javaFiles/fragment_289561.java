new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fadingTextView.stop();
            }
        }, Time_TO_STOP);