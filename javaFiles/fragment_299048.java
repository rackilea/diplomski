Handler handler = new Handler();

    Runnable sendRequest = new Runnable() {
        public void run() {
            // your code to send request 
        }
    };


    new Timer().schedule(new TimerTask() {

        @Override
        public void run() {
            handler.post(sendRequest);
        }
    }, 100, 5000);