final Handler handler = new Handler();
        final int delay = 5000; //milliseconds


        handler.postDelayed(new Runnable(){
            public void run(){
                //do something
                Log.e("XXX", String.valueOf(count));
                count = count + 1;
                if (count != 10) {
                    handler.postDelayed(this, delay);
                }
            }
        }, 0);