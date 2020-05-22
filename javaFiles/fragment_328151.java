Handler handle = new Handler();
    static String signalRres;

    signalRproxy.on(Name of Client Method to send response, new SubscriptionHandler1<String>() {
        @Override
        public void run(String responseString) {
            signalRres = responseString;
            handle.post(run);
        }

    }, String.class);


    Runnable run = new Runnable() {
        @Override
        public void run() {
            Log.e("Running", "Runnable Data" + signalRres);
        }
    };