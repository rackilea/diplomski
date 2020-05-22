final Toast toast = Toast.makeText(ctx, "This message will disappear in 1 second", Toast.LENGTH_SHORT);
        toast.show();

        Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
               @Override
               public void run() {
                   toast.cancel(); 
               }
        }, 1000);