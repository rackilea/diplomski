if (network_connected == false) {
     new CountDownTimer(12000, 1000) {
         public void onTick(long millisUntilFinished) {
             global.toast.setText("Automatic Refresh In: " + millisUntilFinished / 1000);
        global.toast.show();
         }

         public void onFinish() {
            finish();
        startActivity(new Intent(main_activity.this, main_activity.class));
         }
      }.start();
    } else {
    }